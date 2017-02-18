package tracker.start;

/**
 * Input interface add ability to ask a key a do something with input.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.02.2017
 * @version 1
 */
public interface Input {
    /**
     * Add ability to ask a key a do something with input.
     * @param key messages to ask before input
     * @return something that was inputted
     */
    String ask(String key);
}
