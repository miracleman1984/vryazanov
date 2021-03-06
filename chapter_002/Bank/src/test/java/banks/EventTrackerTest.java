package banks;

import banks.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class  with class ValidateStubInput and StubOutput.
 *
 * @author vryazanov
 * @version 1.0
 * @since 27.02.2017
 */


public class EventTrackerTest {
    /**
     * If one client go in and out in different time.
     */
    @Test
    public void whenOneInOutThenShowWhenItWas() {
        Date opens = new Date(2017,3,30,8,00,00);
        Date closes = new Date(2017,3,30,20,00,00);
        Visitor visitor1 = new Visitor(new Date(2017,3,30,7,30),
                new Date(2017,3,30,9,35));
        Visitor visitor2 = new Visitor(new Date(2017,3,30,9,40),
                new Date(2017,3,30,20,05));
        List<Visitor> visitors = new ArrayList<Visitor>();

        visitors.add(visitor1);
        visitors.add(visitor2);

        EventTracker eventTracker = new EventTracker(opens, closes);
        new StartUI(eventTracker, visitors, true).init();
        eventTracker.findMaxLoad();
        ArrayList<TimeRange> timeRanges = eventTracker.findMaxLoad();
        ArrayList<Date> result = new ArrayList<Date>();
        for (TimeRange timeRange : timeRanges) {
            result.add(timeRange.getTimeFrom());
            result.add(timeRange.getTimeTo());
        }
        final Date[] expectedOutput = new Date[]{new Date(2017,3,30,9,40), new Date(2017,3,30,10,00)};
        assertThat(result, is(Arrays.asList(expectedOutput)));
    }

//    /**
//     * If one client go in and out in different time for 2 times.
//     */
//    @Test
//    public void whenOneInOut2TimesThenShowWhenItWas() {
//        Event[] events = new Event[]{new In(9), new Out(10), new In(13), new Out(14)};
//        EventTracker eventTracker = new EventTracker(8, 20);
//        new StartUI(eventTracker, events, true).init();
//        eventTracker.findMaxLoad();
//        ArrayList<TimeRange> timeRanges = eventTracker.findMaxLoad();
//        ArrayList<Long> result = new ArrayList<Long>();
//        for (TimeRange timeRange : timeRanges) {
//            result.add(timeRange.getTimeFrom());
//            result.add(timeRange.getTimeTo());
//        }
//        final Long[] expectedOutput = new Long[]{9L, 10L, 13L, 14L};
//        assertThat(result, is(Arrays.asList(expectedOutput)));
//    }
//
//    /**
//     * If two clients go in and out in different time for 2 times.
//     */
//    @Test
//    public void whenTwoClientGoInOutThenShowWhenItWas() {
//        Event[] events = new Event[]{new In(9), new In(10), new Out(13), new Out(14)};
//        EventTracker eventTracker = new EventTracker(8, 20);
//        new StartUI(eventTracker, events, true).init();
//        eventTracker.findMaxLoad();
//        ArrayList<TimeRange> timeRanges = eventTracker.findMaxLoad();
//        ArrayList<Long> result = new ArrayList<Long>();
//        for (TimeRange timeRange : timeRanges) {
//            result.add(timeRange.getTimeFrom());
//            result.add(timeRange.getTimeTo());
//        }
//        final Long[] expectedOutput = new Long[]{10L, 13L};
//        assertThat(result, is(Arrays.asList(expectedOutput)));
//    }
//
//    /**
//     * If nobody in eventTracker all day.
//     */
//    @Test
//    public void whenAllDayNobodyShowZero() {
//        Event[] events = new Event[]{};
//        EventTracker eventTracker = new EventTracker(8, 20);
//        new StartUI(eventTracker, events, true).init();
//        eventTracker.findMaxLoad();
//        ArrayList<TimeRange> timeRanges = eventTracker.findMaxLoad();
//        ArrayList<Long> result = new ArrayList<Long>();
//        for (TimeRange timeRange : timeRanges) {
//            result.add(timeRange.getTimeFrom());
//            result.add(timeRange.getTimeTo());
//        }
//        final Long[] expectedOutput = new Long[]{};
//        assertThat(result, is(Arrays.asList(expectedOutput)));
//    }
//
//    /**
//     * If two clients go in and stayin until closes.
//     */
//    @Test
//    public void whenTwoClientGoInAndStayThenShowFromTimeWhenWasTwoUntilCloses() {
//        Event[] events = new Event[]{new In(9), new In(10), new Out(13), new Out(14)};
//        EventTracker eventTracker = new EventTracker(8, 20);
//        new StartUI(eventTracker, events, true).init();
//        eventTracker.findMaxLoad();
//        ArrayList<TimeRange> timeRanges = eventTracker.findMaxLoad();
//        ArrayList<Long> result = new ArrayList<Long>();
//        for (TimeRange timeRange : timeRanges) {
//            result.add(timeRange.getTimeFrom());
//            result.add(timeRange.getTimeTo());
//        }
//        final Long[] expectedOutput = new Long[]{10L, 13L};
//        assertThat(result, is(Arrays.asList(expectedOutput)));
//    }
//
//    /**
//     * If nobody was and somebody is going out then this event will be in error log
//     * and this event will not adding to eventLog.
//     */
//    @Test
//    public void whenNobodyWasAndSomebodyGoOutThenIgnoreEventAndAddEventToErrorLog() {
//        Event[] events = new Event[]{new Out(13)};
//        EventTracker eventTracker = new EventTracker(8, 20);
//        new StartUI(eventTracker, events, true).init();
//        ArrayList<Event> errorLog = eventTracker.getWrongEventslog();
//        ArrayList<String> result = new ArrayList<String>();
//        for (Event event : errorLog) {
//            result.add(String.valueOf(event.getEventType()));
//            result.add(String.valueOf(event.getTime()));
//        }
//        final String[] expectedOutput = new String[]{"2", "13"};
//        assertThat(result, is(Arrays.asList(expectedOutput)));
//    }
//

}
