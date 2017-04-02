package banks;

import java.util.Date;

/**
 * TimeRange class that stores timeranges.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 17.03.2017
 */
public class TimeRange {
    int count;



    /**
     * Store timeFrom.
     */
    private Date timeFrom;
    /**
     * Store timeTo.
     */
    private Date timeTo;
    /**
     * Event class constructor.
     *
     * @param timeFrom  timeFrom
     * @param timeTo timeTo
     */
    public TimeRange(Date timeFrom, Date timeTo) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.count = count;
    }
    /**
     * Return timeFrom.
     *
     * @return timeFrom
     */
    public Date getTimeFrom() {
        return timeFrom;
    }
    /**
     * Return timeTo.
     *
     * @return timeTo
     */
    public Date getTimeTo() {
        return timeTo;
    }
}
