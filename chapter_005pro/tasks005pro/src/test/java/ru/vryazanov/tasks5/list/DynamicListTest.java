package ru.vryazanov.tasks5.list;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vr on 17.04.2017.
 */
public class DynamicListTest {
    /**
     * Store array for testing.
     */
    private DynamicList<String> list;

    /**
     * Before each test preparing array.
     */
    @Before
    public void setUp() {
        list = new DynamicList<String>(5);
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
        list.set(2, "Two2");
        assertThat((String) list.get(2), is("Two2"));
    }

    /**
     * If Delete Element By Value Then Should Return Array Without Value.
     */
    @Test
    public void whenDeleteElementByValueThenShouldReturnArrayWithoutValue() {
        list.remove("One2");
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
}