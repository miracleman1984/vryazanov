package ru.vryazanov.tasks5.map;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vr on 13.05.2017.
 */
public class ManWithHashcodeTest {
    /**
     * Created by vr on 13.05.2017.
     */
    @Test
    public void whenFindHashcodeSeveralTimesFromOneObjectThenShouldBeTheSame() {
        Calendar date1 = Calendar.getInstance();
        date1.set(1984, 11, 5);
        ManWithHashcode man1 = new ManWithHashcode("Anatoly", 1, date1);
        int a = man1.hashCode();
        int b = man1.hashCode();
        assertThat(a == b, is(true));
    }
    /**
     * Created by vr on 13.05.2017.
     */
    @Test
    public void whenObjectsEqualThenHashCodeMustBeTheSame() {
        Calendar date1 = Calendar.getInstance();
        date1.set(1984, 11, 5);
        ManWithHashcode man1 = new ManWithHashcode("Anatoly", 1, date1);
        ManWithHashcode man2 = new ManWithHashcode("Anatoly", 1, date1);
        assertThat(man1.equals(man2), is(true));
        assertThat(man1.hashCode() == man2.hashCode(), is(true));
    }
    /**
     * Created by vr on 13.05.2017.
     */
    @Test
    public void whenObjectsNotEqualThenHashCodeCanBeTheSame() {
        Calendar date1 = Calendar.getInstance();
        date1.set(1984, 11, 5);
        ManWithHashcode man1 = new ManWithHashcode("(!", 1, date1);
        ManWithHashcode man2 = new ManWithHashcode("%~", 1, date1);
        assertThat(man1.equals(man2), is(false));
        assertThat(man1.hashCode() == man2.hashCode(), is(true));
    }


}