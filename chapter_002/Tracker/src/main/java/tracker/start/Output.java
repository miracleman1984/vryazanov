package tracker.start;

/**
 * Output interface add ability to add something to chosen output.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.02.2017
 * @version 1
 */
public interface Output {
    /**
     * Add something to chosen output.
     * @param messages messages to be added to chosen output
     */
    void toOutput(String[] messages);
}
