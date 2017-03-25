package bank;

/**
 * UserNotExistsExeption class that show errors user not exists.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 26.03.2017
 * @version 1
 */
public class UserNotExistsExeption extends Throwable {
    /**
     * UserNotExistsExeption class constructor.
     *
     * @param message to show when error is
     */
    public UserNotExistsExeption(String message) {
        super(message);
    }
}
