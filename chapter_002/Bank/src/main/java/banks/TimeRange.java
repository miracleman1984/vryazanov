package banks;

/**
 * TimeRange class that stores timeranges.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 17.03.2017
 */
public class TimeRange {
    /**
     * Store timeFrom.
     */
    private long timeFrom;
    /**
     * Store timeTo.
     */
    private long timeTo;
    /**
     * Event class constructor.
     *
     * @param timeFrom  timeFrom
     * @param timeTo timeTo
     */
    public TimeRange(long timeFrom, long timeTo) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }
    /**
     * Return timeFrom.
     *
     * @return timeFrom
     */
    public long getTimeFrom() {
        return timeFrom;
    }
    /**
     * Return timeTo.
     *
     * @return timeTo
     */
    public long getTimeTo() {
        return timeTo;
    }
}
