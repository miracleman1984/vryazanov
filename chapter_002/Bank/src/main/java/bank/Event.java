package bank;

/**
 * Event class that stores unique properties and methods for all events.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 15.03.2017
 */
public abstract class Event {
    /**
     * Store type of event.
     */
    private int eventType;
    /**
     * Store time when this event happened.
     */
    private long time;
    /**
     * Event class constructor.
     *
     * @param id  type of event
     * @param time when this event happened
     */
     public Event(int id, long time) {
        this.eventType = id;
        this.time = time;
    }
    /**
     * Return type of event.
     *
     * @return type of event
     */
    public int getEventType() {
        return eventType;
    }
    /**
     * Return time when this event happened.
     *
     * @return time when this event happened
     */
    public long getTime() {
        return time;
    }
}
