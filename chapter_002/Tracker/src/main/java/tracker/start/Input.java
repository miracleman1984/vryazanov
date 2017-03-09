package tracker.start;

/**
 * Input interface add ability to ask a key a do something with input.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.02.2017
 * @version 1
 */
public interface Input {
    /**
     * Add ability to ask a key and do something with input.
     * @param key messages to ask before input
     * @return something that was inputted
     */
    String ask(String key);
    /**
     * Add ability to ask a key and do something with input, that can be verified by range and next questions will come
     * to the specific output.
     * @param question messages to ask before input
     * @param range range to check input
     * @param output next questions will come to the specific output
     * @return something that was inputted and verified to int
     */
    int ask(String question, int[] range, Output output);
}
