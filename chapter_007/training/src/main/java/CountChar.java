/**
 * Created by vr on 17.08.2017.
 */
public class CountChar implements Runnable {
    private int counter = 0;

    public void run() {
        System.out.println("!");
        for (Character c : ProgramStop.STRING.toCharArray()) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Значение при прерывании" + counter);
                return;
            }
            counter++;
        }
        System.out.println("Окончательное количество:" + counter);
    }
}
