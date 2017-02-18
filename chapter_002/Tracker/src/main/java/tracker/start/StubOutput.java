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
    private ArrayList<String> answers;

    public void toOutput(String[] messages) {
        Collections.addAll(answers, messages);
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

}
