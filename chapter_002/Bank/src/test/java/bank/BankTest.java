package bank;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Test for class  with class ValidateStubInput and StubOutput.
 *
 * @author vryazanov
 * @version 1.0
 * @since 27.02.2017
 */




/**
 * Created by vr on 15.03.2017.
 */
public class BankTest {
    /**
     * If one client go in and out in different time.
     */
    @Test
    public void whenOneInOutThenShowWhenItWas() {
        Bank bank = new Bank(8,20, new Event[] {new In(9), new Out(10)});
        ArrayList<TimeRange> timeRanges = bank.findMaxLoad(bank.createTimetable());
        ArrayList<Long> result = new ArrayList<Long>();
        for (TimeRange timeRange : timeRanges) {
            result.add(timeRange.getTimeFrom());
            result.add(timeRange.getTimeTo());
        }
        final Long[] expectedOutput = new Long[]{9L, 10L};
        assertThat(result, is(Arrays.asList(expectedOutput)));
    }
    /**
     * If one client go in and out in different time for 2 times.
     */
    @Test
    public void whenOneInOut2TimesThenShowWhenItWas() {
        Bank bank = new Bank(8,20, new Event[] {new In(9), new Out(10), new In(13), new Out(14)});
        ArrayList<TimeRange> timeRanges = bank.findMaxLoad(bank.createTimetable());
        ArrayList<Long> result = new ArrayList<Long>();
        for (TimeRange timeRange : timeRanges) {
            result.add(timeRange.getTimeFrom());
            result.add(timeRange.getTimeTo());
        }
        final Long[] expectedOutput = new Long[]{9L, 10L, 13L, 14L};
        assertThat(result, is(Arrays.asList(expectedOutput)));
    }
    /**
     * If two clients go in and out in different time for 2 times.
     */
    @Test
    public void whenTwoClientGoInOutThenShowWhenItWas() {
        Bank bank = new Bank(8,20, new Event[] {new In(9), new In(10), new Out(13), new Out(14)});
        ArrayList<TimeRange> timeRanges = bank.findMaxLoad(bank.createTimetable());
        ArrayList<Long> result = new ArrayList<Long>();
        for (TimeRange timeRange : timeRanges) {
            result.add(timeRange.getTimeFrom());
            result.add(timeRange.getTimeTo());
        }
        final Long[] expectedOutput = new Long[]{10L, 13L};
        assertThat(result, is(Arrays.asList(expectedOutput)));
    }
}
