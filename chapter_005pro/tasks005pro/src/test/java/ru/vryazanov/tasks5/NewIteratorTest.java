package ru.vryazanov.tasks5;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by vr on 04.04.2017.
 */





public class NewIteratorTest {
    public Iterator<Integer> iterator;

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

    @Test
    public void whenGetNextCallAndThereIsNextIteratorShouldPointerForward() {
        iterator.next();
        iterator.next();
        int result = (Integer) iterator.next();

        assertThat(result, is(1));
    }

    @Test
    public void whenCheckNextPositionAndHaveNextIteratorShouldReturnConstantValue() {

        iterator.next();
        iterator.next();
        iterator.hasNext();
        boolean result = iterator.hasNext();

        assertThat(result, is(true));
    }

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

    @Test(expected = NoSuchElementException.class)
    public void whenGetNextCallAndThereNoNextIteratorShouldReturnError() {

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();

    }

}