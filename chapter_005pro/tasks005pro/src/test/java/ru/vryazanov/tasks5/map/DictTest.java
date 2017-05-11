package ru.vryazanov.tasks5.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * DictTest class
 * <p>
 * Class that checks dict container.
 *
 * @author vryazanov
 * @version 1.0
 * @since 10.05.2017
 */
public class DictTest {
    /**
     * If we adding new items and load factor is lower then given - no resizing.
     */
    @Test
    public void whenAddNewItemsWithoutResizing() {
        Dict<Integer, String> dict1 = new Dict<Integer, String>(20);
        dict1.insert(1, "One");
        dict1.insert(2, "Two");
        dict1.insert(3, "Three");
        dict1.insert(4, "Four");
        assertThat(dict1.getSize(), is(4));
        assertThat(dict1.getLength(), is(20));
    }
    /**
     * If we adding new items and load factor is greater then given - resizing.
     */
    @Test
    public void whenAddNewItemsWithResizing() {
        Dict<Integer, String> dict1 = new Dict<Integer, String>(3);
        dict1.insert(1, "One");
        dict1.insert(2, "Two");
        dict1.insert(3, "Three");
        dict1.insert(4, "Four");
        assertThat(dict1.getSize(), is(4));
        assertThat(dict1.getLength(), is(17));
    }
    /**
     * If we delete Existing Item It Should Be Deleted.
     */
    @Test
    public void whenDeleteExistingItemItShouldBeDeleted() {
        Dict<Integer, String> dict1 = new Dict<Integer, String>(20);
        dict1.insert(1, "One");
        dict1.insert(2, "Two");
        dict1.insert(3, "Three");
        dict1.insert(4, "Four");
        assertThat(dict1.get(2), is("Two"));
        assertThat(dict1.delete(2), is(true));
    }
    /**
     * If we delete Non Existing Item It Should Be False.
     */
    @Test
    public void whenDeleteNonExistingItemItShouldBeFalse() {
        Dict<Integer, String> dict1 = new Dict<Integer, String>(20);
        dict1.insert(1, "One");
        dict1.insert(2, "Two");
        dict1.insert(3, "Three");
        dict1.insert(4, "Four");
        assertThat(dict1.delete(5), is(false));
    }
    /**
     * If we Iterate Through the dict Should Return Right Item.
     */
    @Test
    public void whenIterateThroughShouldReturnRightItem() {
        Dict<Integer, String> dict1 = new Dict<Integer, String>(20);
        dict1.insert(1, "One");
        Iterator iterator = dict1.iterator();
        assertThat((Integer) iterator.next(), is(1));
    }
    /**
     * If we Iterate Through And Delete Should Return Right Item.
     */
    @Test
    public void whenIterateThroughAndDeleteShouldReturnRightItem() {
        Dict<Integer, String> dict1 = new Dict<Integer, String>(20);
        dict1.insert(1, "One");
        Iterator iterator = dict1.iterator();
        assertThat((Integer) iterator.next(), is(1));
    }
    /**
     * If we Iterate Through And Test Next Element Should Be Right.
     */
    @Test
    public void whenIterateThroughtAndTestNextElementShouldBeRight() {
        Dict<Integer, String> dict1 = new Dict<Integer, String>(20);
        dict1.insert(1, "One");
        Iterator iterator = dict1.iterator();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));

    }
}