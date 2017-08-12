package ru.vryazanov.tasks5.extratask;

/**
 * Node operations class
 * <p>
 * Class that contains operations with nodes.
 *
 * @author vryazanov
 * @version 1.0
 * @since 12.08.2017
 */
public class NodeOperations {
    /**
     * Return reversed list of incoming nodes.
     *
     * @param <E> any type of the generic
     * @param startingNode first of incoming nodes
     * @return new starting element for reversed nodes.
     */
    static <E> Node<E> reverseNodeList(Node<E> startingNode) {
        Node<E> nextNode = null;
        Node<E> currentNode = startingNode;

        while (currentNode.getNextNode() != null) {
            Node<E> temp = currentNode.getNextNode();
            currentNode.setNextNode(nextNode);
            nextNode = currentNode;
            currentNode = temp;
        }
        currentNode.setNextNode(nextNode);
        return currentNode;
    }
}
