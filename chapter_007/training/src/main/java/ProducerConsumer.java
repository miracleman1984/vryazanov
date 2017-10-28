import java.util.LinkedList;
import java.util.Queue;

/**
 * Class  ProducerConsumer.
 * <p>
 * Class that shared object and demonstrate producer template
 *
 * @author vryazanov
 * @version 1.0
 * @since 28.10.2017
 */
public class ProducerConsumer {
    /**
     * Store shared queue
     */
    private Queue<String> strings = new LinkedList<String>();

    /**
     * Main method.
     * @param args main args
     * @throws InterruptedException threads interruprion exeption.
     */
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer blockingWork = new ProducerConsumer();
        Producer producer = new Producer(blockingWork.getStrings());
        Consumer consumer = new Consumer(blockingWork.getStrings());

        producer.start();
        consumer.start();
    }

    /**
     * Return shared object
     * @return shared object
     */
    public Queue<String> getStrings() {
        return strings;
    }
}
