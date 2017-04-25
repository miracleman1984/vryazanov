package ru.vryazanov.tasks5.list;

/**
 * Node class
 * <p>
 * Class that contains value and point to the certain next and previous nodes.
 *
 * @param <T> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 25.04.2017
 */
public class Node<T> {
    /**
     * Store internal value.
     */
    private T value;
    /**
     * Store next node of the list.
     */
    private Node<T> next;

    /**
     * Node constructor.
     *
     * @param value set value for the node
     */
    public Node(T value) {
        this.value = value;
    }
    /**
     * Set next element.
     *
     * @param nextNode next element.
     */
    public void setNext(Node<T> nextNode) {
        this.next = nextNode;
    }
    /**
     * Set next element from the node.
     *
     * @return next element from the node.
     */
    public Node<T> getNext() {
        return this.next;
    }
}