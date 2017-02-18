package tracker.start;

/**
 * Created by vr on 16.02.2017.
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[]{"create stub task"});
        StubOutput output = new StubOutput();
        new StartUI(input, output).init();
        for (String s :
                output.getAnswers()) {
            System.out.println(s);
        }
    }
}
