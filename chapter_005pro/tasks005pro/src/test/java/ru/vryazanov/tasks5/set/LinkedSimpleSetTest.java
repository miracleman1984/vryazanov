package ru.vryazanov.tasks5.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * LinkedSimpleSetTest class
 * <p>
 * Class that checks LinkedSimpleSet container.
 *
 * @author vryazanov
 * @version 1.0
 * @since 30.04.2017
 */
public class LinkedSimpleSetTest {
    /**
     * Store array for testing.
     */
    private MySet<String> list;

    /**
     * Before each test preparing array.
     */
    @Before
    public void setUp() {
        list = new LinkedSimpleSet<String>();
    }

    /**
     * If Create Container Should Return Same Type.
     */
    @Test
    public void whenCreateContainerShouldReturnSameType() {
        list.add("One1");
        Iterator iterator = list.iterator();
        assertThat((String) iterator.next(), is("One1"));
    }

    /**
     * If add two equals objects should be only one in set.
     */
    @Test
    public void whenAddingTwoEqualsObjectsThenShouldBeOnlyOneInSet() {
        list.add("One1");
        list.add("One1");
        assertThat(list.size(), is(1));
    }

    /**
     * If iterate until the last element and check is there any element.
     */
    @Test
    public void whenIteratorOnLastElenentAndTestIsThereAnyMoreElementThenShouldBeFalse() {
        list.add("One1");
        Iterator iterator = list.iterator();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

}