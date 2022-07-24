package tahina.netizen;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Board someBoard;
    private Game someGame;

    @Before
    public void testSetup() {
        someBoard = new Board();
        someGame = new Game();
    }

    @Test
    public void when_game_not_over_yet_getWinnerMethod_return_null() {
        assertFalse(someBoard.isFull());
        assertFalse(someGame.isOver(someBoard));

        assertNull(someGame.getWinner(someBoard));
    }

    @Test
    public void when_game_tied_getWinnerMethod_return_null() throws Exception {
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
        someGame
            .setPlayerOne(playerOne)
            .setPlayerTwo(playerTwo);
        String [][] matrixOfSymbol = {
            {"A", "B", null},
            {"A", "A", "B"},
            {null, "B", "A"}
        };
        setBoard(someBoard, matrixOfSymbol);
            
        assertEquals(playerOne, someGame.getWinner(someBoard));
    }

    @Test
    public void when_the_board_is_full_is_overMethod_return_true() throws Exception {
        String [][] matrixOfSymbol = {
            {"O", "X", "O"},
            {"X", "O", "O"},
            {"X", "O", "X"}
        };
        setBoard(someBoard, matrixOfSymbol);

        assertTrue(someGame.isOver(someBoard));
    }

    @Test
    public void when_three_symbols_aligned_isOverMethod_return_true() throws Exception {
        String [][] matrixOfSymbol = {
            {null, "X", "O"},
            {null, null, "O"},
            {"X", null, "O"}
        };
        setBoard(someBoard, matrixOfSymbol);

        assertTrue(someGame.isOver(someBoard));
    }

    @Test
    public void when_board_not_full_and_no_three_symbols_aligned_isOverMethod_return_false() throws Exception {
        String [][] matrixOfSymbol = {
            {null, "X", "O"},
            {null, null, null},
            {"X", null, "O"}
        };
        setBoard(someBoard, matrixOfSymbol);

        assertFalse(someGame.isOver(someBoard));
    }

    @Test
    public void isOverMethod_without_args_just_calls_isOverMethod_by_passing_the_board_game_as_argument() throws Exception {
        Board board;
        String[][] matrixOfSymbol;
        Game game;

        // when the board is full
        matrixOfSymbol = new String[][]{
            {"O", "X", "O"},
            {"X", "O", "O"},
            {"X", "O", "X"}
        };
        board = new Board();
        setBoard(board, matrixOfSymbol);
        game = new Game()
            .setBoard(board);

        assertEquals(game.isOver(board), game.isOver());
        
        // when three symbols aligned
        matrixOfSymbol = new String[][]{
            {null, "X", "O"},
            {null, null, "O"},
            {"X", null, "O"}
        };
        board = new Board();
        setBoard(board, matrixOfSymbol);
        game = new Game()
            .setBoard(board);

        assertEquals(game.isOver(board), game.isOver());

        // when board not full and no three symbols aligned
        matrixOfSymbol = new String[][]{
            {null, "X", "O"},
            {null, null, null},
            {"X", null, "O"}
        };
        board = new Board();
        setBoard(board, matrixOfSymbol);
        game = new Game()
            .setBoard(board);

        assertEquals(game.isOver(board), game.isOver());
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

    @Test
    public void when_game_is_tie_launchMethod_return_null() throws Exception {
        String[][] matrixOfSymbol = {
          {"O", "X", "O"},
          {"X", "O", "X"},
          {"X", "O", "X"}  
        };
        setBoard(someBoard, matrixOfSymbol);
        someGame.setBoard(someBoard);

        assertNull(someGame.launch());
    }

    @Test
    public void when_game_is_not_tie_launchMethod_return_the_correct_player() throws Exception {
        Player p1 = new Player("X");
        Player p2 = new Player("O");
        String[][] matrixOfSymbol = {
            {"O", "O", null},
            {null, null, null},
            {"X", "X", "X"}  
          };
        setBoard(someBoard, matrixOfSymbol);
        someGame
            .setPlayerOne(p1)
            .setPlayerTwo(p2)
            .setBoard(someBoard);
  
        assertEquals(p1, someGame.launch());
    }
}