package ru.vryazanov.tasks5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class  PrimeNumbersIterator.
 *
 * @author vryazanov
 * @version 1.0
 * @since 02.04.2017
 */
public class PrimeNumbersIteratorTest {
    /**
     * If Get Next Call Should Pointer Forward.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        PrimeNumbersIterator it = new PrimeNumbersIterator(new ArrayList<Integer>(Arrays.asList(7, 9, 11, 15)));

        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(11));
    }

    /**
     * If Check Next Position Then Should Return Constant Value.
     */
    @Test
    public void whenCheckNextPositionShouldReturnConstantValue() {
        PrimeNumbersIterator it = new PrimeNumbersIterator(new ArrayList<Integer>(Arrays.asList(7, 9, 11, 15)));

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
        PrimeNumbersIterator it = new PrimeNumbersIterator(new ArrayList<Integer>(Arrays.asList(4, 6, 1158, 4)));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * If no even numbers then next element will rise the error.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNoEvenNumberThenNextShouldReturnError() {
        PrimeNumbersIterator it = new PrimeNumbersIterator(new ArrayList<Integer>(Arrays.asList(4, 6, 1158, 4)));

        it.next();
    }

}