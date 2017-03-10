package tracker.start;

/**
 *  UserAction interface with actions for menu chapters.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 07.03.2017
 */
public interface UserAction {
    /**
     * Return action number (key).
     * @return action number (key)
     */
    int key();
    /**
     * Execute current action.
     * @param input current input
     * @param output current output
     * @param tracker current tracer
     */
    void execute(Input input, Output output, Tracker tracker);
    /**
    * Return string with action description.
    * @return action description
     */
    String info();
}
