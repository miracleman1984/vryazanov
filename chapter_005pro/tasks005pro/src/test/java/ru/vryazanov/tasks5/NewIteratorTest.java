package ru.vryazanov.tasks5;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class  NewIterator.
 *
 * @author vryazanov
 * @version 1.0
 * @since 02.04.2017
 */
public class NewIteratorTest {
    /**
     * Store iterator for testing.
     */
    private Iterator<Integer> iterator;
    /**
     * Before each test preparing iterator.
     */
    @Before
    public void setUp() {
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(2, 3));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1, 3));
        Iterator<Integer> it3 = list1.iterator();
        Iterator<Integer> it4 = list2.iterator();
        List<Iterator<Integer>> iteratorList = new ArrayList<Iterator<Integer>>(Arrays.asList(it3, it4));
        Iterator<Iterator<Integer>> iteratorIterator = iteratorList.iterator();
        NewIterator newIterator = new NewIterator();
        iterator = newIterator.convert(iteratorIterator);
    }
    /**
     * If Get Next Call There Is Next Iterator should Pointer Forward.
     */
    @Test
    public void whenGetNextCallAndThereIsNextIteratorShouldPointerForward() {
        iterator.next();
        iterator.next();
        int result = (Integer) iterator.next();

        assertThat(result, is(1));
    }
    /**
     * If Check Next Position And Have Next Iterator.
     */
    @Test
    public void whenCheckNextPositionAndHaveNextIteratorShouldReturnConstantValue() {

        iterator.next();
        iterator.next();
        iterator.hasNext();
        boolean result = iterator.hasNext();

        assertThat(result, is(true));
    }
    /**
     * If Check Next Position And Have No Next Iterator.
     */
    @Test
    public void whenCheckNextPositionAndHaveNoNextIteratorShouldReturnConstantValue() {

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.hasNext();
        boolean result = iterator.hasNext();

        assertThat(result, is(false));
    }
    /**
     * If Get Next Call And There No Next Iterator.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenGetNextCallAndThereNoNextIteratorShouldReturnError() {

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();

    }

}