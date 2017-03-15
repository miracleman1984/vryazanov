package bank;

/**
 * Created by vr on 15.03.2017.
 */
public class In extends Event {
    public In() {
        super(1, System.currentTimeMillis());
    }

    public In(long time) {
        super(1, time);
    }
}
