package tahina.netizen;

/**
 * The class that handle globally everything about the process of a
 * game of tic tac toe:
 * - init the game
 * - launch the game
 * 
 * But it's main responsibility is to apply the rules of the game:
 * - decide when a game is over
 * - decide the outcome of the game
 * - decide who is the winner
 */
public class Game {
    /**
     * The board of the game
     */
    private Board board;

    /**
     * The player that makes the first move
     */
    private Player playerOne;

    /**
     * The player that moves after the player one
     */
    private Player playerTwo;


    public Game() {
        playerOne = new Player("O");
        playerTwo = new Player("X");
    }

    /**
     * Launch the game and gives the winner
     * @return the player who won the game. If the game is tie, return null
     */
    public Player launch() {
        return null;
    }

    /**
     * Decide if the game in the given board is over according to the tic-tac-toe rules
     * A game is over whether:
     * - the board is full
     * - a player aligned three symbols
     * @param board the board on which to decide if the game is over
     * @return true if the game is over. False otherwise.
     */
    public boolean isOver(Board board) {
        boolean aPlayerWon = getWinner(board) != null;
        return board.isFull() || aPlayerWon;
    }

    /**
     * Just call {@link isOver(Board)} by giving as argument the board of this game
     * @return true if the game is over. False otherwise.
     */
    public final boolean isOver()  {
        return isOver(board);
    }

    /**
     * Decide who is the winner of the game
     * @param board the board on which to decide who is the winner of the game
     * @return the winner if a player won. If the game is a tie or the game is not over
     * yet, return null
     */
    public Player getWinner(Board board) {
        String winnerSymbol;
        if ((winnerSymbol = getWinnerSymbolAlongRows(board)) != null) {
            return getPlayerBySymbol(winnerSymbol);
        }  
        if ((winnerSymbol = getWinnerSymbolAlongColumns(board)) != null) {
            return getPlayerBySymbol(winnerSymbol);
        }
        if((winnerSymbol = getWinnerSymbolAlongDiagonals(board)) != null) {
            return getPlayerBySymbol(winnerSymbol);
        }
        return null;
    }

    private Player getPlayerBySymbol(String winnerSymbol) {
        String playerOneSymbol = playerOne.getSymbol();
        String playerTwoSymbol = playerTwo.getSymbol();
        if (winnerSymbol == playerOneSymbol)  {
            return playerOne;
        }
        if (winnerSymbol == playerTwoSymbol) {
            return playerTwo;
        }
        throw new IllegalArgumentException("Unknown symbol: " + winnerSymbol);
    }

    private String getWinnerSymbolAlongRows(Board anotherBoard) {
        for (int y = 0; y < Board.HEIGHT ; y++) {
            String symbolOnColumn0 = anotherBoard.get(0, y);
            String symbolOnColumn1 = anotherBoard.get(1, y); 
            String symbolOnColumn2 = anotherBoard.get(2, y);
            if (threeSymbolAreEquals(symbolOnColumn0, symbolOnColumn1, symbolOnColumn2)) {
                return symbolOnColumn0;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param symbol0
     * @param symbol1
     * @param symbol2
     * @return true if the 3 given symbols are equals. Exception rule: if one of them is null, return false
     */
    private boolean threeSymbolAreEquals(String symbol0, String symbol1, String symbol2) {
        if (symbol0 == null) return false;
        if (symbol1 == null) return false;
        if (symbol2 == null) return false;

        return symbol0.equals(symbol1) && symbol0.equals(symbol2);
    }

    private String getWinnerSymbolAlongColumns(Board anotherBoard) {
        for (int x = 0; x < Board.HEIGHT ; x++) {
            String symbolOnRow0 = anotherBoard.get(x, 0);
            String symbolOnRow1 = anotherBoard.get(x, 1); 
            String symbolOnRow2 = anotherBoard.get(x, 2);
            if(threeSymbolAreEquals(symbolOnRow0, symbolOnRow1, symbolOnRow2)) {
                return symbolOnRow0;
            }
        }
        return null;
    }

    private String getWinnerSymbolAlongDiagonals(Board anotherBoard) {
        String symbolOnRow0;
        String symbolOnRow1;
        String symbolOnRow2;
        boolean threeSymbolAligned;
        // check the diagonal
        symbolOnRow0 = anotherBoard.get(0, 0);
        symbolOnRow1 = anotherBoard.get(1, 1);
        symbolOnRow2 = anotherBoard.get(2, 2);
        
        if(threeSymbolAreEquals(symbolOnRow0, symbolOnRow1, symbolOnRow2)) {
            return symbolOnRow0;
        }
        // check the opposite diagonal
        symbolOnRow0 = anotherBoard.get(2, 0);
        symbolOnRow1 = anotherBoard.get(1, 1);
        symbolOnRow2 = anotherBoard.get(0, 2);
        if(threeSymbolAreEquals(symbolOnRow0, symbolOnRow1, symbolOnRow2)) {
            return symbolOnRow0;
        }
        
        return null;
    }

    /**
     * Sets the player who play first
     * @param playerOne
     * @return this game for builder pattern
     */
	public Game setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
		return this;
	}

    /**
     * 
     * @param playerTwo
     * @return
     */
    public Game setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
        return this;
    }

    /**
     * Set the board used in this board
     * @param board
     * @return this board for builder pattern
     */
	public Game setBoard(Board board) {
		this.board = board;
        return this;
	}
}
