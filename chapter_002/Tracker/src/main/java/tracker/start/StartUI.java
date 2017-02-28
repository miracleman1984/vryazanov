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
     * @param input set input method
     * @param output set output method
     */
    public StartUI(Input input, Output output) {
        this.input = input;
        this.output = output;
    }
    /**
     * Initialize program.
     */
    public void init() {
        Tracker tracker = new Tracker();
        System.out.println("This is a task tracker");
        Menu menu = new Menu(tracker);
        while (!menu.isExit()) {
            if (menu.isShow()) {
                menu.show();
            }
            menu.choise(input, output);
        }
    }
    /**
     * Initialize program if tracker already exists.
     *
     * @param sourceTracker given tracker from external source
     */
    public void init(Tracker sourceTracker) {
        Tracker tracker = sourceTracker;
        System.out.println("This is a task tracker");
        Menu menu = new Menu(tracker);
        while (!menu.isExit()) {
            if (menu.isShow()) {
                menu.show();
            }
            menu.choise(input, output);
        }
    }

    /**
     * Main module and base logic of the program.
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        new StartUI(input, output).init();
    }
}