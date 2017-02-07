package tracker.models;

/**
 * Task class that stores unique properties and methods for Item type = task.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 06.02.2017
 * @version 1
 */
public class Task extends Item {
    /**
     * Task class constructor.
     * @param name brief summary of task
     * @param desc full story
     */
    public Task(String name, String desc) {
        super(name, desc, System.currentTimeMillis());
    }
    /**
     * Calculate price for the execution.
     * @return price
     */
    public String calculatePrice() {
        return "100%";
    }
}
