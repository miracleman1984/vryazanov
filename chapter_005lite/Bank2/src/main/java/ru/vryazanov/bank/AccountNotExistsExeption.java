package ru.vryazanov.bank;

/**
 * AccountNotExistsExeption class that show errors when account not exists.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 26.03.2017
 * @version 1
 */
public class AccountNotExistsExeption extends Throwable {
    /**
     * AccountNotExistsExeption class constructor.
     *
     * @param message to show when error is
     */
    public AccountNotExistsExeption(String message) {
        super(message);
    }
}
