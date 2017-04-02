package ru.vryazanov.tasks5;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class  Iterator2dArray.
 *
 * @author vryazanov
 * @version 1.0
 * @since 02.04.2017
 */
public class Iterator2dArrayTest {
    /**
     * If Get Next Call Should Pointer Forward.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        Iterator2dArray it = new Iterator2dArray(new int[][]{
                {1, 2},
                {3, 4}
        });

        it.next();
        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(3));
    }
    /**
     * If Check Next Position Then Should Return Constant Value.
     */
    @Test
    public void whenCheckNextPositionShouldReturnConstantValue() {
        Iterator2dArray it = new Iterator2dArray(new int[][]{
                {1, 2},
                {3, 4}
        });

        it.next();
        it.next();
        it.next();
        it.next();
        it.hasNext();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }
}
