package tracker.start;

import java.util.ArrayList;

/**
 * Created by vr on 16.02.2017.
 */
public class ConsoleOutput implements Output {
    @Override
    public void toOutput(String[]  messages) {
        for (String s:
             messages) {
            System.out.println(s);
        }
    }
}
