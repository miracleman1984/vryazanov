package tracker.start;

/**
 * ConsloleInput class show given message to System.out and return string with what a user type, that can be verified by range.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.02.2017
 * @version 1
 */
public class ValidateConsoleInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range, Output output) {
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
