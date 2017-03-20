package chess.chessExceptions;

/**
 * FigureNotFoundException class that shows error when Figure not found.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 20.03.2017
 */
public class FigureNotFoundException extends Exception {
    /**
     * FigureNotFoundException.
     *
     * @param message to show when error is
     */
    public FigureNotFoundException(String message) {
        super(message);
    }
}
