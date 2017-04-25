package ru.vryazanov.tasks5.list;

/**
 * CycleChecker class
 * <p>
 * Class that checks node sequence for cycle.
 *
 * @author vryazanov
 * @version 1.0
 * @since 25.04.2017
 */
public class CycleChecker {

    /**
     * Checks node sequence for cycle..
     *
     * @param startNode starting node
     * @return true if there is any cycles false otherwise
     */
    boolean hasCycle(Node startNode) {
        boolean result = false;
        Node currentNode = startNode;
        Node changingNode = startNode;
        int current = 1;
        while (!result && (currentNode.getNext() != null)) {
            currentNode = currentNode.getNext();
            for (int count = 1; count <= current; count++) {
                if (changingNode == currentNode) {
                    result = true;
                }
                changingNode = changingNode.getNext();
            }
            changingNode = startNode;
            current++;
        }
        return result;
    }
}
