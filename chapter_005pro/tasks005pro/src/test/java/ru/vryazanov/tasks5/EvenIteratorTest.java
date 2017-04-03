package ru.vryazanov.tasks5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class  EvenIterator.
 *
 * @author vryazanov
 * @version 1.0
 * @since 03.04.2017
 */
public class EvenIteratorTest {
    /**
     * If Get Next Call Should Pointer Forward.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        EvenIterator it = new EvenIterator(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 6)));

        it.next();
        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(6));
    }

    /**
     * If Check Next Position Then Should Return Constant Value.
     */
    @Test
    public void whenCheckNextPositionShouldReturnConstantValue() {
        EvenIterator it = new EvenIterator(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 6)));

        it.next();
        it.next();
        it.next();
        it.hasNext();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }

    /**
     * If no even numbers then no next element.
     */
    @Test
    public void whenNoEvenNumberThenHasNextShouldReturnFalse() {
        EvenIterator it = new EvenIterator(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7)));

        assertThat(it.hasNext(), is(false));
    }

    /**
     * If no even numbers then next element will rise the error.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNoEvenNumberThenNextShouldReturnError() {
        EvenIterator it = new EvenIterator(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7)));

        it.next();
    }

}