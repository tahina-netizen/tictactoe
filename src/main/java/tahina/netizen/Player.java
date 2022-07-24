package tahina.netizen;

import java.util.Scanner;
/**
 * Can make a play
 */
public class Player {
    public static final Scanner SCANNER = new Scanner(System.in);
    /**
     * The symbol that this player places on the board when he plays
     */
    private String symbol;

    public Player(String symbol) {
        if(symbol == null) {
            throw new IllegalArgumentException("Given symbol is null");
        }
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public Point play() {
        System.out.print("> " + getSymbol() + ", your play: ");
        String input = SCANNER.next();
        int x = Character.getNumericValue(input.charAt(0));
        int y = Character.getNumericValue(input.charAt(1));

        return new Point(x, y, this.getSymbol());
    }
}
