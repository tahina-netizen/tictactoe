package tahina.netizen;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Board board = new Board()
            .set(0, 0, "X")
            .set(1, 1, "X")
            .set(2, 2, "X"); 
        System.out.println( "Welcome to Tic tac toe" );
        System.out.print(board.toString());
    }
}
