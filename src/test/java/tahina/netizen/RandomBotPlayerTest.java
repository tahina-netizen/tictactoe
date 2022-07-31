package tahina.netizen;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * A player that plays random moves
 */
public class RandomBotPlayerTest {
    @Test
    public void when_board_is_full_playMethod_return_null() throws Exception {
        //given a board that is full
        Board board = new Board();
        String[][] matrixOfSymbol = {
            {"X", "O", "X"},
            {"X", "X", "O"},
            {"O", "X", "O"}
        };
        TestUtil.setBoard(board, matrixOfSymbol);
        Player bot = new RandomBotPlayer("X");

        // when the random bot player plays
        Point actual = bot.play(board);

        // then play() return null
        assertNull(actual);
    }

    @Test
    public void when_board_not_full_playMethod_return_a_valid_play() {
        // given a board that is not full
        Board board =  new Board();
        Player bot = new RandomBotPlayer("O");

        // when the random bot player plays
        Point actual = bot.play(board);

        // then play() return a point associated to a free cell
        assertTrue(board.isCellAvailable(actual.getX(), actual.getY()));
    }
}
