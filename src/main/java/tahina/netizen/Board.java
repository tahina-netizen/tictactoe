package tahina.netizen;

public class Board {
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
     */
    public Board set(int x, int y, String symbol) {
        try {
            matrixOfSymbol[x][y] = symbol;
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("(%d, %d) is out of bound for board", x, y));
        }
        return this;
    }

    public String toString() {
        String res = "";
        for (int x = 0; x < matrixOfSymbol.length; x++) {
            String line = "";
            for (int y = 0; y < matrixOfSymbol.length; y++) {
                line += matrixOfSymbol[x][y];
            }
            line += "\n";
            res += line;
        }
        return res;
    }

    public boolean isFull() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if(matrixOfSymbol[x][y].equals(BLANK_CELL_SYMBOL)) {
                    return false;
                }
            } 
        }
        return true;
    }
}
