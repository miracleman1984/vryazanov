package ru.vryazanov.tasks5.list;


/**
 * Interface  MyQueues.
 * <p>
 * Interface for all queues and stacks such as fifo and lifo.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 24.04.2017
 */
public interface MyQueues<E> {
    /**
     * Add new element into the array.
     * @param e adding value
     *
     */
    void push(E e);
    /**
     * Delete element ifrom the top.
     *
     * @return deleted element ifrom the top
     */
    //delete element from the top
    E pop();
    /**
     * Return current size of array.
     *
     * @return current size of array.
     */
    int size();
}
