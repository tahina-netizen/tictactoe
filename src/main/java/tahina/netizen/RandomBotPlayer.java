package tahina.netizen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomBotPlayer extends Player {

    public RandomBotPlayer(String symbol) {
        super(symbol);
    }

    /**
     * Choose randomly one of the current free cell in the given board
     * @return the random play. Null if the board is full (since no cell can
     * be chosen)
     */
    @Override
    public Point play(Board gameBoard) {
        List<Point> legalPlays = new ArrayList<>();
        for (int row = 0; row < Board.HEIGHT; row++) {
            for (int col = 0; col < Board.WIDTH; col++) {
                if (gameBoard.isCellAvailable(col, row)) {
                    Point cell = new Point(col, row, getSymbol());
                    legalPlays.add(cell);
                }
            }
        }
        if (legalPlays.isEmpty()) {
            return null;
        }
        int dice = ThreadLocalRandom.current().nextInt(0, legalPlays.size());
        Point randomPlay = legalPlays.get(dice);
        System.out.println(
            String.format(
                "%s choosed to play (%d, %d)",
                getSymbol(), randomPlay.getX(), randomPlay.getY()
            )
        );
        return randomPlay;
    }  
}
