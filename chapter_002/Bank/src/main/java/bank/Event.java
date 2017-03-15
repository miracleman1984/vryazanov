package bank;

/**
 * Event class that stores unique properties and methods for all events.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 15.03.2017
 */
public abstract class Event {
    private int eventType;
    private long time;

     Event(int id, long time) {
        this.eventType = id;
        this.time = time;
    }

    public int getEventType() {
        return eventType;
    }

    public long getTime() {
        return time;
    }
}
