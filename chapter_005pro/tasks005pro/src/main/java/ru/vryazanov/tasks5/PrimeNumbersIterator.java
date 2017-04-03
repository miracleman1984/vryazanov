package ru.vryazanov.tasks5;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class  PrimeNumbersIterator.
 * <p>
 * Iterator for prime numbers.
 *
 * @author vryazanov
 * @version 1.0
 * @since 02.04.2017
 */
public class PrimeNumbersIterator implements Iterator {
    /**
     * Store massive that iterator go through.
     */
    private final ArrayList<Integer> values;
    /**
     * Store current index to iterate.
     */
    private int nextPrime = -1;

    /**
     * EvenIterator constructor.
     *
     * @param values massive that iterator go through
     */
    public PrimeNumbersIterator(ArrayList<Integer> values) {
        this.values = values;
        findNextPrime();
    }

    /**
     * If current index exists for the massive.
     *
     * @return true if index exists for the massive and false otherwise
     */
    public boolean hasNext() {
        return (nextPrime != -1) ? true : false;
    }

    /**
     * Return next element to iterate.
     * And move forward the pointer (index)
     *
     * @return next iterate value
     */
    public Object next() {
        //вывод текущего элемента
        int result = values.get(nextPrime);
        //перевод каретки
        this.findNextPrime();
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
    private void findNextPrime() {
        boolean findPrime = true;
        for (int i = nextPrime + 1; i < values.size(); i++) {
            findPrime = true;
            int currentValue = this.values.get(i);
            for (int j = 2; j < Math.sqrt(currentValue) + 1; j++) {
                if (currentValue % j == 0) {
                    findPrime = false;
                }
            }
            if (findPrime) {
                nextPrime = i;
                break;
            }
        }
        if (!findPrime) {
            nextPrime = -1;
        }
    }
}
