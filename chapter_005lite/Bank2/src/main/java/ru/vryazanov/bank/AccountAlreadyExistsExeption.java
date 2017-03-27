package ru.vryazanov.bank;

/**
 * AccountAlreadyExistsExeption class that show errors when account exists.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 26.03.2017
 * @version 1
 */
public class AccountAlreadyExistsExeption extends Throwable {

    /**
     * AccountAlreadyExistsExeption class constructor.
     *
     * @param message to show when error is
     */
    public AccountAlreadyExistsExeption(String message) {
        super(message);
    }
}
