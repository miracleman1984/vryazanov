import java.util.Queue;

/**
 * Class  Consumer.
 * <p>
 * Class that get jobs from a shared queue and operates on it.
 *
 * @author vryazanov
 * @version 1.0
 * @since 28.10.2017
 */
public class Consumer extends Thread {
    /**
     * Store shared queue
     */
    private Queue<String> queue;
    /**
     * Consumer constructor/
     * @param queue shared queue
     */
    public Consumer(Queue<String> queue) {
        this.queue = queue;
        this.setName("Consumer");
    }

    /**
     * Run
     */
    public void run() {
        System.out.println("Starting " + Thread.currentThread().getName());
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is waiting for notifying about new job... ");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " deleting first queue element....");
                System.out.println(Thread.currentThread().getName() + ": " + queue.poll() + " element is polled");
                System.out.println(Thread.currentThread().getName() + ": current queue: " + queue);
            }
        }
    }
}
