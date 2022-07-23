package tahina.netizen;

/**
 * Tic tac toe game
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("App init");
        // new game
        Game game = new Game();

        // launch the game
        Player winner = game.launch();

        // display the winner
        displayWinner(winner);

        // exit
        System.out.println("Exiting the app");
        Player.SCANNER.close();        
    }

    private static void displayWinner(Player winner) {
        if (winner == null) {
            System.out.println("Tie game, no winner");
        } else {
            System.out.println("The winner is " + winner.getSymbol());
        }    
    }
}
