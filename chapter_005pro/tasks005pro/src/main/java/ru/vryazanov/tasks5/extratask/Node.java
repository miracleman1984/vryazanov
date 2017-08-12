package ru.vryazanov.tasks5.extratask;

/**
 * Node class
 * <p>
 * Class that contains value and point to the certain next node.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 12.08.2017
 */
public class Node<E> {
    /**
     * Store internal value.
     */
    private E value;
    /**
     * Store next node of the list.
     */
    private Node<E> nextNode;
    /**
     * Node constructor.
     *
     * @param value set value for the node
     * @param nextNode set next node for the node
     */
    public Node(E value, Node<E> nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }
    /**
     * Return node value.
     *
     * @return value node value.
     */
    public E getValue() {
        return value;
    }
    /**
     * Return next element.
     *
     * @return nextNode next element.
     */
    public Node<E> getNextNode() {
        return nextNode;
    }
    /**
     * Set next element.
     *
     * @param nextNode next element.
     */
    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{"
                + "value="
                + value
                + ", nextNode="
                + nextNode
                + '}';
    }
}
