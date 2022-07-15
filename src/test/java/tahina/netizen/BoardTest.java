package tahina.netizen;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BoardTest {
    @Test(expected = IllegalArgumentException.class)
    public void when_setting_a_symbol_out_of_bound_exception_is_throwed() {
        Board someBoard = new Board();
        someBoard.set(Board.WIDTH + 1000, Board.HEIGHT + 1000, "X");
    }

    @Test
    public void when_the_board_is_full_isFullMethod_return_true() {
        Board someBoard = new Board();
        makeFull(someBoard);

        assertTrue(someBoard.isFull());
    }

    private static void makeFull(Board someBoard) {
        for (int x = 0; x < Board.WIDTH; x++) {
            for (int y = 0; y < Board.HEIGHT; y++) {      
                someBoard.set(x, y, "X");
            }
        }
    }

    @Test
    public void when_the_board_is_not_full_isFullMethod_return_false() {
        Board someBoard = new Board();
        someBoard.set(0, 0, "X");

        assertFalse(someBoard.isFull());
    }
 
}
