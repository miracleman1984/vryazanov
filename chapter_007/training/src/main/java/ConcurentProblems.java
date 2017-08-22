import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import static java.lang.Thread.sleep;

/**
 * Created by vr on 21.08.2017.
 */
public class ConcurentProblems {
    public static int test1;
    public static int test2;

    public static void main(String[] args) throws InterruptedException {
        SharedObject sharedObject = new SharedObject();
        Thread first = new Thread(new First());
        Thread second = new Thread(new First());
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println(SharedObject.sharedVar1);
    }
}