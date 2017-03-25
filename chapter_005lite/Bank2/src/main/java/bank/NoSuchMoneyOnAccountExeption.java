package bank;

/**
 * NoSuchMoneyOnAccountExeption class that show errors when no such money exists on the account.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 26.03.2017
 * @version 1
 */
public class NoSuchMoneyOnAccountExeption extends Throwable {
    /**
     * NoSuchMoneyOnAccountExeption class constructor.
     *
     * @param message to show when error is
     */
    public NoSuchMoneyOnAccountExeption(String message) {
        super(message);
    }
}
