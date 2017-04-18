package ru.vryazanov.tasks5.list;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DynamicList class
 * <p>
 * Some class that can denonstrate container as a array with generalize types.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 18.04.2017
 */
public class DynamicList<E> implements ListAnalogy<E> {
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
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Store current size of internal array.
     */
    private int size;

    /**
     * DynamicList constructor.
     *
     * @param initialSize initial size of the array
     */
    public DynamicList(int initialSize) {
        this.size = initialSize;
        this.objects = new Object[size];
    }

    /**
     * DynamicList dafault constructor.
     */
    public DynamicList() {
        this.size = DEFAULT_CAPACITY;
        this.objects = new Object[size];
    }

    /**
     * Extend size of internal array.
     */
    public void grow() {

        objects = Arrays.copyOf(objects, 2 * size);
    }

    /**
     * Add new element into the array.
     * And move forward the pointer (index)
     *
     * @param value adding value
     */
    public void add(E value) {
        // увеличение размера массива, если достигли предела
        if (index >= size) {
            grow();
        }
        this.objects[index++] = value;
    }

    /**
     * Return element on the position.
     *
     * @param position of array to be returned
     * @return element on the position.
     */
    public E get(int position) {

        return (E) this.objects[position - 1];
    }

    /**
     * Change element on the position by the value.
     *
     * @param position of array to be changed
     * @param newValue new value
     */
    public void set(int position, E newValue) {

        this.objects[position - 1] = newValue;
    }

    /**
     * Return current size of array.
     *
     * @return current size of array.
     */
    public int size() {

        return this.size;
    }

    /**
     * Delete element in the array by the value.
     *
     * @param value that should be deleted
     * @return result of the operation true if at least one element was removed and false otherwise
     */
    public boolean remove(E value) {
        boolean result = false;
        //todo: delete all objects with this value
        int count = 0;
        for (int i = 1; i <= this.index; i++) {
            if (value.equals(this.objects[i])) {
                System.arraycopy(this.objects, i + 1, this.objects, i, this.index - i - 1);
                i--;
                index--;
                result = true;
            }
        }
        return result;
    }

    /**
     * Delete element in the array by the position.
     *
     * @param position on which we should delete a value
     */
    public void delete(int position) {
        //todo: delete object on the position
        System.arraycopy(this.objects, position, this.objects, position - 1, this.objects.length - position);
        index--;
    }

    /**
     * Internal iterator for internal array.
     * @return  internal iterator
     */
    public Iterator<E> iterator() {

        return new Itr();
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
            return cursor != size;
        }

        @Override
        public E next() {
            if (cursor >= size) {
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
     * Return current length of array.
     *
     * @return current length of array
     */
    public int getIndex() {
        return index;
    }
}
