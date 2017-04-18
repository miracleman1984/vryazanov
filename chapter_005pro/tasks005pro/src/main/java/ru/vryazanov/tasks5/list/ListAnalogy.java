package ru.vryazanov.tasks5.list;

import java.util.Iterator;

/**
 * Interface  ListAnalogy.
 * <p>
 * Interface for internal listcontainers.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 18.04.2017
 */
public interface ListAnalogy<E> extends Iterable<E> {
    /**
     * Return current size of array.
     *
     * @return current size of array.
     */
    int size();

    /**
     * Add new element into the array.
     * And move forward the pointer (index)
     *
     * @param value adding value
     */
    void add(E value);

    /**
     * Return element on the position.
     *
     * @param position of array to be returned
     * @return element on the position.
     */
    E get(int position);

    /**
     * Change element on the position by the value.
     *
     * @param position of array to be changed
     * @param newValue new value
     */
    void set(int position, E newValue);

    /**
     * Delete element in the array by the value.
     *
     * @param value that should be deleted
     * @return result of the operation true if at least one element was removed and false otherwise
     */
    boolean remove(E value);

    /**
     * Delete element in the array by the position.
     *
     * @param position on which we should delete a value
     */
    void delete(int position);

    /**
     * Iterator for internal array.
     *
     * @return internal iterator
     */
    Iterator<E> iterator();
}
