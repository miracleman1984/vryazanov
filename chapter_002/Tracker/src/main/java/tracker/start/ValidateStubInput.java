package tracker.start;

import java.util.ArrayList;

/**
 * StubInput class return string from a massive with answers, that can be verified by range if we want to.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.02.2017
 * @version 1
 */
public class ValidateStubInput extends StubInput {
    /**
     * Store answers for input asking.
     */
    private String[] answers;
    /**
    * ValidateStubInput class constructor.
    *
    * @param answers answers for input asking.
    */
    public ValidateStubInput(ArrayList<String> answers) {
        super(answers);
    }
    @Override
    public int ask(String question, ArrayList<Integer> range, Output output) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range, output);
                invalid = false;
            } catch (MenuOutException moe) {
                output.toOutput("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                output.toOutput("Please enter valid data again,");
            }
        } while (invalid);

        return value;
    }
}
