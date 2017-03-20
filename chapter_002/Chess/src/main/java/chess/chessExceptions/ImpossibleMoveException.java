package chess.chessExceptions;

/**
 * ImpossibleMoveException class that shows error when move is impossible.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 20.03.2017
 */
public class ImpossibleMoveException extends Exception {
    /**
     * ImpossibleMoveException class constructor.
     *
     * @param message to show when error is
     */
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
