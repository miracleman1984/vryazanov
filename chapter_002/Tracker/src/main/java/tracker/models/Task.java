package tracker.models;

/**
 * Task class that stores unique properties and methods for Item type = task.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 06.02.2017
 */
public class Task extends Item {
    /**
     * Task class constructor.
     *
     * @param name brief summary of task
     * @param desc full story
     */
    public Task(String name, String desc) {

        super(name, desc, System.currentTimeMillis());
    }
    /**
     * Task class constructor.
     *
     * @param name brief summary of task
     * @param desc full story
     * @param id   given id from external source
     */
    public Task(String name, String desc, String id) {
        super(name, desc, System.currentTimeMillis(), id);
    }

    /**
     * Calculate price for the execution.
     *
     * @return price
     */
    public String calculatePrice() {
        return "100%";
    }
}
