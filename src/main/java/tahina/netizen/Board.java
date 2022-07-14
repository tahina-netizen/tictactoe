package tahina.netizen;

public class Board {
    /**
     *
     */
    private static final String BLANK_CELL_SYMBOL = ".";
    private String[][] matrixOfSymbol;

    public Board() {
        matrixOfSymbol = new String[3][3];
        for (int x = 0; x < matrixOfSymbol.length; x++) {
            for (int y = 0; y < matrixOfSymbol.length; y++) {
               matrixOfSymbol[x][y] = BLANK_CELL_SYMBOL;
            }
        }
    }

    public Board set(int x, int y, String symbol) {
        matrixOfSymbol[x][y] = symbol;
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
}
