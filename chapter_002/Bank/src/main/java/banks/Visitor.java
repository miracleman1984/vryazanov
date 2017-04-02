package banks;

import java.util.Date;

/**
 * Created by vr on 30.03.2017.
 */
public class Visitor {
    Date in;
    Date out;

    public Visitor(Date in, Date out) {
        this.in = in;
        this.out = out;
    }
}
