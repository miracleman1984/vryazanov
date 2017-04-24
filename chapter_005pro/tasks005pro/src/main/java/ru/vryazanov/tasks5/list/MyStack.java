package ru.vryazanov.tasks5.list;


/**
 * MyStack class
 * <p>
 * Some class for  demonstrate LIFO last in last out queue container.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 24.04.2017
 */

public class MyStack<E> implements MyQueues<E> {
    /**
     * Store internal massive of objects.
     */
    private DynamicLinkedList<E> list;
    /**
     * MyStack constructor.
     *
     */
    public MyStack() {
        this.list = new DynamicLinkedList<E>();
    }

    @Override
    public void push(E e) {
        list.add(e);
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public int size() {
        return list.size();
    }
}
