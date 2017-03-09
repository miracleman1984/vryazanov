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
     * Store ranges that menu can operates.
     */
    private int[] ranges;
    /**
     * Store input method.
     */
    private Input input;
    /**
     * Store output method.
     */
    private Output output;
    /**
     * Store current tracker.
     */
    private Tracker tracker;

    /**
     * StartUI class constructor.
     *
     * @param input  set input method
     * @param output set output method
     * @param tracker set current tracker
     */
    public StartUI(Tracker tracker, Input input, Output output) {
        this.input = input;
        this.output = output;
        this.tracker = tracker;
    }
    /**
     * Initialize program.
     *
     */
    public void init() {
        System.out.println("This is a task tracker");
        MenuTracker menu = new MenuTracker(this.input, this.output, this.tracker);
        menu.fillActions();
        int[] ranges = menu.getRange();
        do {
            menu.show();
            menu.select(input.ask("select: ", ranges, this.output));
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }

    /**
     * Main module and base logic of the program.
     *
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        Input input = new ValidateConsoleInput();
        Output output = new ConsoleOutput();
        new StartUI(new Tracker(), input, output).init();
    }
}