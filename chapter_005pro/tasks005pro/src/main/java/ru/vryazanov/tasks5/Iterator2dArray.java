package ru.vryazanov.tasks5;

import java.util.Iterator;

/**
 * Class  Iterator2dArray.
 * <p>
 * Iterator for 2d arrays.
 *
 * @author vryazanov
 * @version 1.0
 * @since 02.04.2017
 */
public class Iterator2dArray implements Iterator {
    /**
     * Store massive that iterator go through.
     */
    private final int[][] values;
    /**
     * Store current index to iterate.
     */
    private int index = 0;

    /**
     * Iterator2dArray constructor.
     *
     * @param values massive that iterator go through
     */
    public Iterator2dArray(int[][] values) {

        this.values = values;
    }

    /**
     * If current index exists for the massive.
     *
     * @return true if index exists for the massive and false otherwise
     */
    public boolean hasNext() {

        return values[0].length * values[1].length > index;
    }

    /**
     * Return next element to iterate.
     * And move forward the pointer (index)
     *
     * @return next iterate value
     */
    public Object next() {
        int indexX = index / values[0].length;
        int indexY = index % values[0].length;
        index++;
        return values[indexX][indexY];
    }

    /**
     * Just for compatibility.
     */
    public void remove() {

    }
}
