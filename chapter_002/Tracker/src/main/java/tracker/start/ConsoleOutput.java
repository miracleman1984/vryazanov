package tracker.start;


/**
 * ConsloleOutput class show given messages to System.out.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 18.02.2017
 */
public class ConsoleOutput implements Output {
    @Override
    public void toOutput(String[] messages) {
        for (String s : messages) {
            System.out.println(s);
        }
    }
}
