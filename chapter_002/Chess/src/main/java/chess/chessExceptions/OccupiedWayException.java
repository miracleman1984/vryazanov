package chess.chessExceptions;

/**
 * OccupiedWayException class that shows error when on the way exitsts other figures.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 20.03.2017
 */
public class OccupiedWayException extends Exception {
    /**
     * OccupiedWayException class constructor.
     *
     * @param message to show when error is
     */
    public OccupiedWayException(String message) {
        super(message);
    }
}
