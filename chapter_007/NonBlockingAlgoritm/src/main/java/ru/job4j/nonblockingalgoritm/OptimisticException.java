package ru.job4j.nonblockingalgoritm;

/**
 * Class OptimisticException
 * <p>
 * Class for synchronization errors runtime exceptions.
 *
 * @author vryazanov
 * @version 1.0
 * @since 05.12.2017
 */
public class OptimisticException extends RuntimeException {
    /**
     * Print error desctiption
     *
     * @param newValue version of the model
     * @param oldValue version of the model
     */
    public OptimisticException(int newValue, int oldValue) {
        System.out.println(" oldValue = " + oldValue + " newValue = " + newValue + "  " + Thread.currentThread().getName());
    }
}
