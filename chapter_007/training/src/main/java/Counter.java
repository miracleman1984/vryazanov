

/**
 * Class  Counter.
 * <p>
 * Thread that operates on counters
 *
 * @author vryazanov
 * @version 1.0
 * @since 06.09.2017
 */

public final class Counter {
    /**
     * Store counter.
     */
    private int count;

    /**
     * Incrementing of inner counter.
     *
     * @return counter that was incremented
     */

    public synchronized int incremant() {
        return ++this.count;
    }

    @Override
    public synchronized String toString() {
        return "Counter{"
                + "count="
                + count
                + '}';
    }
}
