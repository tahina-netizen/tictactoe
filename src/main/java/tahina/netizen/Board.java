package tahina.netizen;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The board:
 * - can be modified
 * - can be read
 */
public class Board implements Iterable<String> {
    public static int WIDTH = 3;
    public static int HEIGHT = 3;
    private static final String BLANK_CELL_SYMBOL = ".";

    private String[][] matrixOfSymbol;

    /**
     * Create a board with no symbol yet
     */
    public Board() {
        matrixOfSymbol = new String[3][3];
        for (int x = 0; x < matrixOfSymbol.length; x++) {
            for (int y = 0; y < matrixOfSymbol.length; y++) {
               matrixOfSymbol[x][y] = BLANK_CELL_SYMBOL;
            }
        }
    }

    /**
     * set a symbol in the given coordinate on this board
     * @return this board (for builder pattern)
     * @throws IllegalArgumentException if (x, y) is out of the board
     * @throws IllegalPlayException if trying to set a symbol on an already taken cell
     */
    public Board set(int x, int y, String symbol) throws IllegalPlayException {
        if (! isValidCoordinates(x, y)) {
            throw new IllegalArgumentException(String.format("(%d, %d) is out of bound for board", x, y));
        }
        if(! isCellAvailable(x, y)) {
            throw new IllegalPlayException(String.format("(%d, %d) is already taken", x, y));
        }
        matrixOfSymbol[x][y] = symbol;
        return this;
    }

    public String toString() {
        String res = "  0 1 2\n";
        for (int y = 0; y < matrixOfSymbol.length; y++) {
            String col0 = matrixOfSymbol[0][y];
            String col1 = matrixOfSymbol[1][y];
            String col2 = matrixOfSymbol[2][y];
            String line = String.format("%d %s|%s|%s\n",
                y, col0, col1, col2
            );
            res += line;
        }
        return res;
    }

    public boolean isFull() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if(isCellAvailable(x, y)) {
                    return false;
                }
            } 
        }
        return true;
    }

    /**
     * 
     * @param x
     * @param y
     * @return true iff the cell (x, y) is empty. Otherwise, false. 
     * If (x, y) is out of bound, it's considered unavailable too.
     */
    public boolean isCellAvailable(int x, int y) {
        if (isValidCoordinates(x, y)) {
            return matrixOfSymbol[x][y].equals(BLANK_CELL_SYMBOL);
        }
        else {
            return false;
        }
    }

    /**
     * 
     * @param x
     * @param y
     * @return true iff (x, y) is not out of bound. Otherwise, false.
     */
    private boolean isValidCoordinates(int x, int y) {
        return x < WIDTH && y < HEIGHT;
    }

    /**
     * @param x
     * @param y
     * @return the symbol place on (x, y). If (x, y) does not contain any symbol, return
     * null. 
     * @throws IllegalArgumentException If (x, y) is out of bound
     */
    public String get(int x, int y) {
        if(isValidCoordinates(x, y)) {
            String symbol = matrixOfSymbol[x][y];
            return symbol.equals(BLANK_CELL_SYMBOL) ? null: symbol;
        }
        throw new IllegalArgumentException(
            String.format("Coordinates out of bound: (%d, %d)", x, y)
        );
    }

    public static boolean isBlankCellSymbol(String symbol) {
        return symbol.equals(BLANK_CELL_SYMBOL);
    }

    /**
     * @return an iterator that iterate through the board row per row (beginning with (0, 0))
     * 
     */
    @Override
    public Iterator<String> iterator() {
        List<String> listOfSymbols = new LinkedList<>();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                listOfSymbols.add(get(x, y));
            } 
        }
        return listOfSymbols.iterator();
    }
}
