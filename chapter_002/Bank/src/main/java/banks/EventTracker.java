package banks;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Bank class that stores unique properties and methods for all items.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 15.03.2017
 */
public class EventTracker {

    /**
     * Store when bank is opens.
     */
    private long opens;
    /**
     * Store when bank is closes.
     */
    private long closes;
    /**
     * Store bank eventlog.
     */
    private ArrayList<Event> eventlog = new ArrayList<Event>();
    /**
     * Store error Log with wrong events.
     */
    private ArrayList<Event> wrongEventslog = new ArrayList<Event>();
    /**
     * Store error messages.
     */
    private ArrayList<String> errorLog = new ArrayList<String>();
    /**
     * Store is Error Log will be.
     */
    private boolean isErrorLog;

    /**
     * EventTracker class constructor.
     *
     * @param opens  when bank is opens
     * @param closes when bank is closes
     */
    public EventTracker(long opens, long closes) {
        this.opens = opens;
        this.closes = closes;
        this.isErrorLog = false;
    }

    /**
     * Set is Error Log will be.
     *
     * @param isLog is Error Log will be.
     */
    public void setLogLevel(Boolean isLog) {
        this.isErrorLog = isLog;
    }

    /**
     * Add new event.
     *
     * @param event to be added to log
     */
    public void add(Event event) {
        try {
            this.testAddToEventlog(event.getEventType());
            this.eventlog.add(event);
        } catch (ConsistenceErrorException e) {
            if (this.isErrorLog) {
                this.errorLog.add("Вышло больше чем вошло Время: " + event.getTime());
                this.wrongEventslog.add(event);
            }
        }
    }

    /**
     * Testing what will happens if we add new event to log.
     *
     * @param type of testing event
     * @throws ConsistenceErrorException exception for something wrong
     */
    private void testAddToEventlog(Integer type) throws ConsistenceErrorException {
        int countIn = 0;
        int countOut = 0;
        if (type == 1) {
            countIn++;
        } else if (type == 2) {
            countOut++;
        }

        for (Event e : this.eventlog) {
            if (e.getEventType() == 1) {
                countIn++;
            } else if (e.getEventType() == 2) {
                countOut++;
            }
        }
        if (countOut > countIn) {
            throw new ConsistenceErrorException();
        }

    }

    /**
     * Return Timeranges when load was max.
     *
     * @return TimeRanges
     */
    public ArrayList<TimeRange> findMaxLoad() {
        LinkedHashMap<Long, Integer> map = this.createTimetable();
        ArrayList<TimeRange> result = new ArrayList<TimeRange>();
        long timeFrom = this.opens;
        long timeTo = this.closes;
        int count = 0;
        for (Event event : eventlog) {
            long eventTime = event.getTime();
            int increment = (event.getEventType() == 1) ? 1 : -1;
            count += increment;
            map.put(eventTime, count);
        }
        int max = 0;
        for (Map.Entry<Long, Integer> pair : map.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, Integer> item = (Map.Entry) it.next();
            if (item.getValue() == max) {
                timeFrom = item.getKey();
                if (it.hasNext()) {
                    timeTo = ((Map.Entry<Long, Integer>) it.next()).getKey();
                }
                result.add(new TimeRange(timeFrom, timeTo));
                timeTo = this.closes;
            }
        }
        System.out.println(max);
        return result;
    }

    /**
     * Return timetable with pairs time:load.
     *
     * @return timetable
     */
    public LinkedHashMap<Long, Integer> createTimetable() {
        LinkedHashMap<Long, Integer> map = new LinkedHashMap<Long, Integer>();
        int count = 0;
        for (Event event : eventlog) {
            long eventTime = event.getTime();
            int increment = (event.getEventType() == 1) ? 1 : -1;
            count += increment;
            if (eventTime >= opens && eventTime <= closes) {
                map.put(eventTime, count);
            }
        }
        System.out.println(map);
        return map;
    }

    /**
     * Return WrongEventslog.
     *
     * @return WrongEventslog
     */
    public ArrayList<Event> getWrongEventslog() {
        return wrongEventslog;
    }
}
