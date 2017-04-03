package ru.vryazanov.tasks5;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class  EvenIterator.
 * <p>
 * Iterator for 2d arrays.
 *
 * @author vryazanov
 * @version 1.0
 * @since 02.04.2017
 */
public class EvenIterator implements Iterator {
    /**
     * Store massive that iterator go through.
     */
    private final ArrayList<Integer> values;
    /**
     * Store current index to iterate.
     */
    private int nextEven = -1;

    /**
     * EvenIterator constructor.
     *
     * @param values massive that iterator go through
     */
    public EvenIterator(ArrayList<Integer> values) {
        this.values = values;
        findNextEven();
    }

    /**
     * If current index exists for the massive.
     *
     * @return true if index exists for the massive and false otherwise
     */
    public boolean hasNext() {
        return (nextEven != -1) ? true : false;
    }

    /**
     * Return next element to iterate.
     * And move forward the pointer (index)
     *
     * @return next iterate value
     */
    public Object next() {
        //вывод текущего элемента
        int result = values.get(nextEven);
        //перевод каретки
        this.findNextEven();
        return result;
    }

    /**
     * Just for compatibility.
     */
    public void remove() {

    }

    /**
     * Find next index for even number.
     * Set nextEven to -1 if it was found no items.
     */
    private void findNextEven() {
        boolean findEven = false;
        for (int i = nextEven + 1; i < values.size(); i++) {
            if (this.values.get(i) % 2 == 0) {
                this.nextEven = i;
                findEven = true;
                break;
            }
        }
        if (!findEven) {
            nextEven = -1;
        }
    }
}
