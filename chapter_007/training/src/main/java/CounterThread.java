/**
 * Created by vr on 06.09.2017.
 */
public final class CounterThread extends Thread{
    protected final Counter counter;

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
