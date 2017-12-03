package ru.job4j.waitnotifynotifyall;

/**
 * Class  Counter.
 * <p>
 * Thread that operates on counters
 *
 * @author vryazanov
 * @version 1.0
 * @since 06.09.2017
 */

public class Counter {
    /**
     * Store counter.
     */
    private int count;

    /**
     * Incrementing of inner counter.
     *
     * @return counter that was incremented
     */

    public synchronized int incremant() throws InterruptedException {
        ++this.count;
        System.out.println(Thread.currentThread().getName() + " is executing " + this.count + " work.");
        Thread.currentThread().sleep(1000);
        System.out.println(Thread.currentThread().getName() + " is finished " + this.count + " work.");
        return this.count;
    }

    @Override
    public synchronized String toString() {
        return " " + count + " ";
    }
}
