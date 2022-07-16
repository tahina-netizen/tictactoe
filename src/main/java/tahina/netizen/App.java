package tahina.netizen;

/**
 * Tic tac toe game
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // creating a new board
        Board board = new Board();
        System.out.println( "Welcome to Tic tac toe" );
        

        // new player
        Player player = new Player("X");

        // asking where the player will put his symbol until the board is full
        while(! board.isFull()) {
            System.out.print(board.toString());
            Point playerPlay = player.play();
            try {
                board.set(playerPlay.getX(), playerPlay.getY(), playerPlay.getSymbol());
            } catch (IllegalArgumentException e) {
                System.out.println("That play is out of bound. Retry again");
            } catch (IllegalPlayException e) {
                System.out.println("That play is illegal. Try again");
            }
        }
        System.out.print(board.toString());
        System.out.println("Game is over");
        Player.SCANNER.close();
    }
}
