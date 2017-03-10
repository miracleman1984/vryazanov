package tracker.start;

/**
 *  BaseAction class with actions for menu chapters.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 07.03.2017
 */
public abstract class BaseAction implements UserAction {
    /**
     * Store decription for the action.
     */
    private String name;
    /**
     *BaseAction class constructor.
     *
     * @param name  set decription for the action
     */
    public BaseAction(String name) {
        this.name = name;
    }

    @Override
    public abstract int key();

    @Override
    public abstract void execute(Input input, Output output, Tracker tracker);

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
