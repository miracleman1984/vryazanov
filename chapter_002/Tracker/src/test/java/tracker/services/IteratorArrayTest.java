package tracker.services;

import org.junit.Test;

import java.util.Iterator;
import java.util.Objects;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by vr on 31.03.2017.
 */
public class IteratorArrayTest {

    public static final class ForEachArray implements Iterable {

        private final int values[];

        public ForEachArray(final int[] values) {
            this.values = values;
        }

        @Override
        public Iterator iterator() {
            return new IteratorArray(this.values);
        }
    }

    @Test
    public void whenGetNextCallShouldPointerForward() {
        IteratorArray it = new IteratorArray(new int[] {1,3});

        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(3));
    }

    @Test
    public void whenCheckNextPositionShouldReturmConstantValue() {
        IteratorArray it  = new IteratorArray(new int[] {1});

        it.next();
        it.hasNext();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }

    @Test
    public void foreach() {
        ForEachArray foreach = new ForEachArray(new int[] {1,4,5});

        for (Object value : foreach) {
            System.out.println(value);
        }
    }
}