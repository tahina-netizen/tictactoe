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

        // set players
        Player p1 = askForPlayer("Choose player one\n", "X");
        Player p2 = askForPlayer("Choose player two\n", "O");
        game.setPlayerOne(p1);
        game.setPlayerTwo(p2);

        // launch the game
        Player winner = game.launch();

        // display the winner
        displayWinner(winner);

        // exit
        System.out.println("Exiting the app");
        Player.SCANNER.close();        
    }

    private static Player askForPlayer(String msg, String symbol) {
        msg += "1. Human\n";
        msg += "2. Bot\n";
        System.out.println(msg);
        System.out.print("> Your choice: ");
        String input = Globals.SCANNER.next();
        int choice = -1;
        try {
            choice = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }
        Player player;
        player = convertNumberToPlayer(msg, symbol, choice);
        return player;
    }

    /**
     * Ask which type of player to choose from the user UNTIL he enter a valid choice
     * @param msg message for asking a player to the user
     * @param symbol the symbol that will be attributed to the player
     * @param choice the number of the choice the user entered
     * @return an instance of the player type the user choosed. The given symbol is attributed
     * to that player
     */
    private static Player convertNumberToPlayer(String msg, String symbol, int choice) {
        Player player;
        switch (choice) {
            case 1:
                player = new Player(symbol);
                break;
            case 2:
                player = new RandomBotPlayer(symbol);
                break;
            default:
                System.out.println("Invalid choice, try again.");
                player = askForPlayer(msg, symbol);
                break;
        }
        return player;
    }

    private static void displayWinner(Player winner) {
        if (winner == null) {
            System.out.println("Tie game, no winner");
        } else {
            System.out.println("The winner is " + winner.getSymbol());
        }    
    }
}
