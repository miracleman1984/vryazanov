package bank;

/**
 * Created by vr on 15.03.2017.
 */
public class Out extends Event {
    public Out() {
        super(2, System.currentTimeMillis());
    }

    public Out(long time) {
        super(2, time);
    }
}