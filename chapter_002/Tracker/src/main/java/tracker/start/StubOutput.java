package tracker.start;

import java.util.ArrayList;
import java.util.Collections;

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
    private ArrayList<String> answers;
    /**
     * Add messages to massive .
     * @param messages messages to be added to massive
     */
    public void toOutput(String[] messages) {
        Collections.addAll(answers, messages);
    }
    /**
     * Return information that was written while program was running.
     * @return information that was written while program was running.
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }
}
