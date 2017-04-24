package ru.vryazanov.tasks5.list;


/**
 * MyQueue class
 * <p>
 * Some class for  demonstrate FIFO first-in-first-out queue container.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 24.04.2017
 */
public class MyQueue<E> implements MyQueues<E> {
    /**
     * Store internal massive of objects.
     */
    private DynamicLinkedList<E> list;
    /**
     * MyQueue constructor.
     *
     */
    public MyQueue() {
        this.list = new DynamicLinkedList<E>();
    }

    @Override
    public void push(E e) {
        list.add(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public int size() {
        return list.size();
    }
}
