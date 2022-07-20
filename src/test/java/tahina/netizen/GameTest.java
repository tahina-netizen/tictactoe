package tahina.netizen;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
    @Test
    public void when_game_not_over_yet_getWinnerMethod_return_null() {
        Game someGame = new Game();
        Board someBoard = new Board();
        assertFalse(someBoard.isFull());
        assertFalse(someGame.isOver(someBoard));

        assertNull(someGame.getWinner(someBoard));
    }

    @Test
    public void when_game_tied_getWinnerMethod_return_null() throws Exception {
        Game someGame = new Game();
        Board someBoard = new Board();
        String [][] matrixOfSymbol = {
            {"O", "X", "O"},
            {"X", "X", "O"},
            {"O", "O", "X"}
        };
        setBoard(someBoard, matrixOfSymbol);
            
        assertNull(someGame.getWinner(someBoard));
    }


    @Test
    public void when_a_player_won_getWinnerMethod_return_the_correct_player() throws Exception {
        Player playerOne = new Player("A");
        Player playerTwo = new Player("B");
        Game someGame = new Game()
            .setPlayerOne(playerOne)
            .setPlayerTwo(playerTwo);
        Board someBoard = new Board();
        String [][] matrixOfSymbol = {
            {"A", "B", null},
            {"A", "A", "B"},
            {null, "B", "A"}
        };
        setBoard(someBoard, matrixOfSymbol);
            
        assertEquals(playerOne, someGame.getWinner(someBoard));
    }

    private static void setBoard(Board someBoard, String[][] matrixOfSymbol) throws Exception {
        for (int x = 0; x < matrixOfSymbol.length; x++) {
            for (int y = 0; y < matrixOfSymbol.length; y++) {
                if(matrixOfSymbol[x][y] != null) {
                    someBoard.set(x, y, matrixOfSymbol[x][y]);
                }
            }
        }
    }
}