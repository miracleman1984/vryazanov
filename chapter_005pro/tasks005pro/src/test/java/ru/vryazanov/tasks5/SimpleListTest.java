package ru.vryazanov.tasks5;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class  SimpleList.
 *
 * @author vryazanov
 * @version 1.0
 * @since 08.04.2017
 */
public class SimpleListTest {
    /**
     * Store array for testing.
     */
    private SimpleList list;
    /**
     * Before each test preparing array.
     */
    @Before
    public void setUp() {
        list = new SimpleList<String>(5);
        list.add("One1");
        list.add("One2");
        list.add("One3");
        list.add("One2");
        list.add("One3");
    }
    /**
     * If Create Container Should Return Same Type.
     */
    @Test
    public void whenCreateContainerShouldReturnSameType() {
        list.get(1);
        assertThat((String) list.get(1), is("One1"));
    }
    /**
     * If Create Container Should Return Same Type.
     */
    @Test
    public void whenUpdateElementThenShouldReturnUpdatedElement() {
        list.update(2, "Two2");
        assertThat((String) list.get(2), is("Two2"));
    }
    /**
     * If Delete Element By Value Then Should Return Array Without Value.
     */
    @Test
    public void whenDeleteElementByValueThenShouldReturnArrayWithoutValue() {
        list.delete("One2");
        assertThat((String) list.get(3), is("One3"));
        assertThat(list.getIndex(), is(3));
    }
    /**
     * If Delete Element On Position Then Should Return Array Without On This Position.
     */
    @Test
    public void whenDeleteElementOnPositionThenShouldReturnArrayWithoutOnThisPosition() {
        list.delete(2);
        assertThat((String) list.get(2), is("One3"));
        assertThat(list.getIndex(), is(4));
    }
}