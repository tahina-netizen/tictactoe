package tahina.netizen;

/**
 * An illegal play in a play that does not follow the rule of the game such as:
 * - placing a symbol on an cell where there is already one
 */
public class IllegalPlayException extends Exception {
    public IllegalPlayException() {
        super("Unknown illegal play");
    }
    public IllegalPlayException(String msg) {
        super(msg);
    }
}
