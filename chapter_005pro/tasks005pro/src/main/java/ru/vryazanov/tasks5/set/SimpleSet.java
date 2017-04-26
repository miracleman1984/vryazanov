package ru.vryazanov.tasks5.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleSet class
 * <p>
 * Some class that can demonstrate set.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 26.04.2017
 */
public class SimpleSet<E> implements MySet<E> {
    /**
     * Store internal massive of objects.
     */
    private Object[] objects;
    /**
     * Store curent lenght of the array.
     */
    private int index = 0;
    /**
     * Store default capacity of internal array.
     */
    private static final int DEFAULT_SIZE = 20;
    /**
     * Store current size of internal array.
     */
    private int size;
    /**
     * SimpleSet dafault constructor.
     */
    public SimpleSet() {
        this.size = DEFAULT_SIZE;
        this.objects = new Object[DEFAULT_SIZE];
    }

    /**
     * Extend size of internal array.
     */
    public void grow() {

        objects = Arrays.copyOf(objects, 2 * index);
    }
    /**
     * Testing is element already is in the internal arrayn.
     *
     * @param e item for testing
     * @return true if element already in the array and false otherwise.
     */
    public boolean duplicateTest(E e) {
        boolean result = false;
        for (Object object : objects) {
            if (object.equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Add new element into the array.
     * And move forward the pointer (index)
     *
     * @param e adding value
     */
    public void add(E e) {
        if (index == 0 || !duplicateTest(e)) {
            if (index >= size) {
                grow();
            }
            this.objects[index++] = e;
        }
    }

    @Override
    public Iterator<E> iterator() {

        return new SimpleSet.Itr();
    }
    /**
     * Itr class
     * <p>
     * Class that defining internal iterator.
     *
     */
    private class Itr implements Iterator<E> {
        /**
         * Store current index to iterate.
         */
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != index;
        }

        @Override
        public E next() {
            if (cursor >= index) {
                throw new NoSuchElementException();
            }
            return (E) objects[cursor++];
        }

        @Override
        public void remove() {
            if (cursor == 0) {
                throw new IllegalStateException();
            }
            System.arraycopy(objects, cursor, objects, cursor - 1, objects.length - cursor - 1);
            size--;
            cursor--;
        }
    }

    /**
     * Return current size of array.
     *
     * @return current size of array.
     */
    public int size() {

        return this.index;
    }
}
