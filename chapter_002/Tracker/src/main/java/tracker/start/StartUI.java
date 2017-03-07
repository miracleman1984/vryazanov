package tracker.start;

/**
 * StartUI initialize the program and main logic..
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 18.02.2017
 */
public class StartUI {
    /**
     * Store input method.
     */
    private Input input;
    /**
     * Store output method.
     */
    private Output output;

    /**
     * StartUI class constructor.
     *
     * @param input  set input method
     * @param output set output method
     */
    public StartUI(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    /**
     * Initialize program.
     *
     * @param sourceTracker given tracker from external source
     */
    public void init(Tracker sourceTracker) {
        System.out.println("This is a task tracker");
        MenuTracker menu = new MenuTracker(this.input, this.output, sourceTracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }

    /**
     * Main module and base logic of the program.
     *
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        new StartUI(input, output).init(new Tracker());
    }
}