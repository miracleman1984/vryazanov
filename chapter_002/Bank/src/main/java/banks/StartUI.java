package banks;

import banks.Event;
import banks.EventTracker;

/**
 * StartUI initialize the program and main logic..
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 17.03.2017
 */
public class StartUI {
    /**
     * Store current event tracker.
     */
    private EventTracker eventTracker;
    /**
     * Store events for adding when program initializing.
     */
    private Event[] startingEvents;
    /**
     * Store is Error Log will be.
     */
    private Boolean isErrorLog;
    /**
     * StartUI class constructor.
     *
     * @param eventTracker  current event tracker.
     * @param startingEvents events for adding when program initializing.
     * @param isLog is Error Log will be.
     */
    public StartUI(EventTracker eventTracker, Event[] startingEvents, boolean isLog) {
        this.eventTracker = eventTracker;
        this.startingEvents = startingEvents;
        this.isErrorLog = isLog;
    }
    /**
     * Initialize program.
     *
     */
    public void init() {
        eventTracker.setLogLevel(isErrorLog);
        for (Event event: startingEvents) {
            eventTracker.add(event);
        }
    }
}
