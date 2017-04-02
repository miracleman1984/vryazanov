package banks;


import java.util.*;

/**
 * Bank class that stores unique properties and methods for all items.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 15.03.2017
 */
public class EventTracker {
    private List<Visitor> visitors;
    /**
     * Store when bank is opens.
     */
    private Date opens;
    /**
     * Store when bank is closes.
     */
    private Date closes;
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
    public EventTracker(Date opens, Date closes) {
        this.opens = opens;
        this.closes = closes;
        this.isErrorLog = false;
        this.visitors = new ArrayList<Visitor>();
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
     * Add new visitior.
     *
     * @param visitor to be added to log
     */
    public void add(Visitor visitor) {
            this.eventlog.add(new In(visitor.in));
            this.eventlog.add(new Out(visitor.out));
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
        Map<Date, Integer> map = this.createTimetable();
        ArrayList<TimeRange> result = new ArrayList<TimeRange>();
        Date timeFrom = this.opens;
        Date timeTo = this.closes;
        int count = 0;
        for (Event event : eventlog) {
            Date eventTime = event.getTime();
            int increment = (event.getEventType() == 1) ? 1 : -1;
            count += increment;
           // System.out.println(eventTime + "  "+ count);
            map.put(eventTime, count);
        }
        int max = 0;
        for (Map.Entry<Date, Integer> pair : map.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Date, Integer> item = (Map.Entry) it.next();
            if (item.getValue() == max) {
                timeFrom = item.getKey();
                if (it.hasNext()) {
                    timeTo = ((Map.Entry<Date, Integer>) it.next()).getKey();
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
    public Map<Date, Integer> createTimetable() {
        Collections.sort(eventlog, new Comparator<Event>() {
            public int compare(Event o1, Event o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
        Map<Date, Integer> map = new TreeMap<Date, Integer>();
        int count = 0;
        for (Event event : eventlog) {
            Date eventTime = event.getTime();
            int increment = (event.getEventType() == 1) ? 1 : -1;
            count += increment;
            if (eventTime.compareTo(opens) >= 0 && eventTime.compareTo(closes) <= 0) {
                System.out.println(eventTime + " " + count);
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
