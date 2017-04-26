package ru.vryazanov.tasks5.set;

/**
 * Interface  MySet.
 * <p>
 * Interface for internalcontainer.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 26.04.2017
 */
public interface MySet<E> extends Iterable<E> {
    /**
     * Add new element into the array.
     * And move forward the pointer (index)
     *
     * @param e adding value
     */
    void add(E e);
    /**
     * Return current size of array.
     *
     * @return current size of array.
     */
    int size();
}
