package tracker.start;

/**
 * MenuOutException class show errors in the menu input.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.02.2017
 * @version 1
 */
public class MenuOutException extends RuntimeException {
    /**
     * MenuOutExceptio class constructor.
     *
     * @param msg to show when error is
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
