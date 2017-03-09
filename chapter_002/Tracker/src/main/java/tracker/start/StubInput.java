package tracker.start;

/**
 * StubInput class return string from a massive with answers.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.02.2017
 * @version 1
 */
public class StubInput implements Input {
    /**
     * Store answers for input asking.
     */
    private String[] answers;
    /**
     * Store current position in massive.
     */
    private int position = 0;
    /**
     * StubInput class constructor.
     *
     * @param answers answers for input asking.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Initialize program.
     * @param question request
     * @return next answers element
     */
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, int[] range, Output output) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }

}

