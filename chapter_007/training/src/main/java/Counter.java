import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Created by vr on 06.09.2017.
 */
@ThreadSafe

public final class Counter {
    private int count;
    @GuardedBy("this")
    public synchronized int incremant() {
        return ++this.count;
    }

    @GuardedBy("this")
    @Override
    public synchronized String toString() {
        return "Counter{" +
                "count=" + count +'}';
    }
}
