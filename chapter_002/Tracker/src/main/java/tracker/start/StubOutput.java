package tracker.start;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by vr on 16.02.2017.
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
