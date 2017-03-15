package bank;

/**
 * Created by vr on 15.03.2017.
 */
public class TimeRange {
    private long timeFrom;
    private long timeTo;

    public TimeRange(long timeFrom, long timeTo) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public long getTimeFrom() {
        return timeFrom;
    }

    public long getTimeTo() {
        return timeTo;
    }
}
