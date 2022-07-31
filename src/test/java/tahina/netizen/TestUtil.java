package tahina.netizen;

public class TestUtil {
    static void setBoard(Board someBoard, String[][] matrixOfSymbol) throws Exception {
        for (int x = 0; x < matrixOfSymbol.length; x++) {
            for (int y = 0; y < matrixOfSymbol.length; y++) {
                if(matrixOfSymbol[x][y] != null) {
                    someBoard.set(x, y, matrixOfSymbol[x][y]);
                }
            }
        }
    }
    
}
