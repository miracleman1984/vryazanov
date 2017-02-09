package tracker.models;

/**
 * Bug class that stores unique properties and methods for Item type = bug.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 06.02.2017
 * @version 1
 */
public class Bug extends Item {
    /**
     * Bug class constructor.
     * @param name brief summary of task
     * @param desc full story
     */
    public Bug(String name, String desc) {
        super(name, desc, System.currentTimeMillis());
    }
}
