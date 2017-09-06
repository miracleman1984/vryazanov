/**
 * Class  CounterThread.
 * <p>
 * Thread that operates on counters
 *
 * @author vryazanov
 * @version 1.0
 * @since 06.09.2017
 */
public final class CounterThread extends Thread {
    /**
     * Store inner Counter object.
     */
    protected final Counter counter;

    /**
     * CounterThread constructor.
     *
     * @param counter set an inner Counter object
     */
    public CounterThread(final Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.incremant();
        }
    }
}
