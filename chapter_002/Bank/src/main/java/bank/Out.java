package bank;

/**
 * Created by vr on 15.03.2017.
 */
public class Out extends Event {
    /**
     * Out class constructor.
     *
     */
    public Out() {
        super(2, System.currentTimeMillis());
    }
    /**
     * Out class constructor.
     *
     * @param time when event happened
     *
     */
    public Out(long time) {
        super(2, time);
    }

}