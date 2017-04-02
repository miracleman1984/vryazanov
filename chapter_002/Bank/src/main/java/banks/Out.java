package banks;

import banks.Event;

import java.util.Date;

/**
 * Created by vr on 15.03.2017.
 */
public class Out extends Event {
    /**
     * Out class constructor.
     *
     */

    /**
     * Out class constructor.
     *
     * @param time when event happened
     *
     */
    public Out(Date time) {
        super(2, time);
    }

}