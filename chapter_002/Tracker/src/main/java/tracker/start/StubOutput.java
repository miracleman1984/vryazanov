package tracker.start;

import java.util.ArrayList;

/**
 * StubOutput class to add something to an array and then return this array.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.02.2017
 * @version 1
 */
public class StubOutput implements Output {
    /**
     * Store information for output.
     */
    private ArrayList<String> answers = new ArrayList<>();

    /**
     * Add messages to massive .
     * @param message messages to be added to massive
     */

    public void toOutput(String message) {
        answers.add(message);
    }
    /**
     * Return information that was written while program was running.
     * @return information that was written while program was running.
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }
}
