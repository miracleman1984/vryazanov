import java.util.Queue;

/**
 * Class  Producer.
 * <p>
 * Class that add new jobs to shared queue.
 *
 * @author vryazanov
 * @version 1.0
 * @since 28.10.2017
 */
public class Producer extends Thread {
    /**
     * Store shared queue
     */
    private Queue<String> queue;

    /**
     * Producer constructor/
     *
     * @param queue shared queue
     */
    public Producer(Queue<String> queue) {
        this.queue = queue;
        this.setName("Producer");
    }

    /**
     * Run
     */
    public void run() {
        System.out.println("Starting " + Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            synchronized (queue) {
                System.out.println(Thread.currentThread().getName() + " adding new element to job queue...");
                queue.add(String.format("%s", i));
                System.out.println(String.format("%s: %s added", Thread.currentThread().getName(), i));
                System.out.println(Thread.currentThread().getName() + ": current queue: " + queue);
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " notify Consumer to start its work");
                    queue.notify();
                }
            }
            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep for 0.5s ...");
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
