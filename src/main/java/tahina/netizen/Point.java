package tahina.netizen;

/**
 * Data class representing a play made by a player.
 * Can give the coordinates and the symbol of the play
 */
public class Point {
    private int x;
    private int y;
    private String symbol;

    public Point(int x, int y, String symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public int getX() {
        return x;    
    }
    
    public int getY() {
        return y;
    }

    public String getSymbol() {
        return symbol;
    }
}
