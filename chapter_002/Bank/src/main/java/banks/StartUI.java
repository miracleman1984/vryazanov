package banks;

import banks.Event;
import banks.EventTracker;

import java.util.List;

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
    private List<Visitor> startingVisitors;
    /**
     * Store is Error Log will be.
     */
    private Boolean isErrorLog;
    /**
     * StartUI class constructor.
     *
     * @param eventTracker  current event tracker.
     * @param startingVisitors
     * @param isLog is Error Log will be.
     */
    public StartUI(EventTracker eventTracker, List<Visitor> startingVisitors, boolean isLog) {
        this.eventTracker = eventTracker;
        this.startingVisitors = startingVisitors;
        this.isErrorLog = isLog;
    }
    /**
     * Initialize program.
     *
     */
    public void init() {
        eventTracker.setLogLevel(isErrorLog);
        for (Visitor visitor: startingVisitors) {
            eventTracker.add(visitor);
        }
    }
}
