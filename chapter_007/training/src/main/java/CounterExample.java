import net.jcip.annotations.ThreadSafe;

/**
 * Class  CounterExample.
 * <p>
 * class for demonstration of monitor and syncing
 *
 * @author vryazanov
 * @version 1.0
 * @since 06.09.2017
 */
@ThreadSafe
public class CounterExample {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterThread thread1 = new CounterThread(counter);
        CounterThread thread2 = new CounterThread(counter);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}
