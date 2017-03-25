package bank;

/**
 * UserAlreadyExistsExeption class that show errors user already exists.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 26.03.2017
 * @version 1
 */
public class UserAlreadyExistsExeption extends Throwable {
    /**
     * UserAlreadyExistsExeption class constructor.
     *
     * @param message to show when error is
     */
    public UserAlreadyExistsExeption(String message) {
        super(message);
    }
}
