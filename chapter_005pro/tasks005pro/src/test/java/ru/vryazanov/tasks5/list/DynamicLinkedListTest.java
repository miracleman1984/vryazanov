package ru.vryazanov.tasks5.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vr on 19.04.2017.
 */
public class DynamicLinkedListTest {
    /**
     * Store array for testing.
     */
    private DynamicLinkedList<String> list;

    /**
     * Before each test preparing array.
     */
    @Before
    public void setUp() {
        list = new DynamicLinkedList<String>();
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
        assertThat((String) list.get(5), is("One3"));
    }

    /**
     * If iterate until the last element and check is there any element.
     */
    @Test
    public void whenIteratorOnLastElenentAndTestIsThereAnyMoreElementThenShouldBeFalse() {
        Iterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));

    }

    /**
     * If iterate through array and check elements.
     */
    @Test
    public void whenIteratorGetElenentThenShouldBeRightElement() {
        Iterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        assertThat((String) iterator.next(), is("One3"));
    }

    /**
     * If iterate through array and remove element from the middle.
     */
    @Test
    public void whenIteratorDeleteElenentsThenShouldBeDeleted() {
        Iterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        assertThat((String) list.get(3), is("One2"));
    }

    /**
     * If iterate through array and remove element from the end.
     */
    @Test
    public void whenIteratorDeleteLastElenentThenShouldBeDeleted() {
        Iterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();
        assertThat(iterator.hasNext(), is(false));
        assertThat(list.size(), is(4));
    }
}
