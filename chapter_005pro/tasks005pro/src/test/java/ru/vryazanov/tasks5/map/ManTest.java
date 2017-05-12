package ru.vryazanov.tasks5.map;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ManTest class
 * <p>
 * Class that checks man class.
 *
 * @author vryazanov
 * @version 1.0
 * @since 12.05.2017
 */
public class ManTest {
    /**
     * Compare with null.
     */
    @Test
    public void whenCompareToNullThenShouldBeFalse() {
        Calendar date1 = Calendar.getInstance();
        date1.set(1984, 11, 5);
        Man man1 = new Man("Vitaly", 2, date1);
        assertThat(man1.equals(null), is(false));
    }

    /**
     * Compare with the same object.
     */
    @Test
    public void whenObjectsTheSameThenShouldBeTrue() {
        Calendar date1 = Calendar.getInstance();
        date1.set(1984, 11, 5);
        Man man1 = new Man("Vitaly", 1, date1);
        assertThat(man1.equals(man1), is(true));
    }

    /**
     * Mirror comparing when Objects Are Equals.
     */
    @Test
    public void whenObjectsAreEqualsThenMirrorCompareShouldBeTrue() {
        Calendar date1 = Calendar.getInstance();
        date1.set(1984, 11, 5);
        Man man1 = new Man("Vitaly", 1, date1);
        Man man2 = new Man("Vitaly", 1, date1);
        assertThat(man1.equals(man2) == man2.equals(man1), is(true));
    }

    /**
     * Mirror comparing when Objects Are not  Equals.
     */
    @Test
    public void whenObjectsAreNotEqualsThenMirrorCompareShouldBeTrue() {
        Calendar date1 = Calendar.getInstance();
        date1.set(1984, 11, 5);
        Man man1 = new Man("Anatoly", 1, date1);
        Man man2 = new Man("Vitaly", 1, date1);
        assertThat(man1.equals(man2) == man2.equals(man1), is(true));
    }

    /**
     * if х.equals(z) == y.equals(z) then х.equals(z) == x.equals(y).
     */
    @Test
    public void whenTwoObjectsAreNotEqualsToThirdThenThatObjectShouldntBeEqual() {
        Calendar date1 = Calendar.getInstance();
        date1.set(1984, 11, 5);
        Man man1 = new Man("Anatoly", 1, date1);
        Man man2 = new Man("Vitaly", 1, date1);
        Man man3 = new Man("Stepan", 1, date1);
        assertThat(man1.equals(man3), is(false));
        assertThat(man2.equals(man3), is(false));
        assertThat(man1.equals(man3), is(false));
    }

    /**
     * Compare object after changing one of them when change does not effect  on equality.
     */
    @Test
    public void whenTwoObjectsAreEqualsAndWeUnsignificallyChangeOneThenThatObjectShouldBeEqual() {
        Calendar date1 = Calendar.getInstance();
        date1.set(1984, 11, 5);
        Man man1 = new Man("Anatoly", 1, date1);
        Man man2 = new Man("Anatoly", 1, date1);
        assertThat(man1.equals(man2), is(true));
        man2.setChildren(2);
        assertThat(man1.equals(man2), is(true));
    }
}