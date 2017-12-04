package ru.job4j.nonblockingalgoritm;

/**
 * Created by vvryazanov on 04.12.2017.
 */
public class OptimisticException extends RuntimeException {
    public OptimisticException(int newValue, int oldValue) {
        System.out.println(" oldValue = " + oldValue + " newValue = " + newValue + "  " + Thread.currentThread().getName());
    }
}
