package bank;

/**
 * In class for event when somebosy go in.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 15.03.2017
 */
public class In extends Event {
    /**
     * In class constructor.
     *
     */
    public In() {
        super(1, System.currentTimeMillis());
    }
    /**
     * In class constructor.
     *
     * @param time when event happened
     *
     */
    public In(long time) {
        super(1, time);
    }
}
