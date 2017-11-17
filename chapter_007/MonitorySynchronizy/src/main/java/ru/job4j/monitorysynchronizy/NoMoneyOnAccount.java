package ru.job4j.monitorysynchronizy;

/**
 * Created by vr on 07.09.2017.
 */
public class NoMoneyOnAccount extends Throwable {
    public NoMoneyOnAccount(String message) {
        super(message);
    }
}
