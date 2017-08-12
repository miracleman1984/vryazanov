package ru.vryazanov.tasks5.extratask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vr on 12.08.2017.
 */
public class NodeOperationsTest {
    /**
     * If 3 incoming linked nodes should reverse it.
     */
    @Test
    public void when3ElementsInListShouldReverse() {
        Node<Integer> node3 = new Node<Integer>(3, null);
        Node<Integer> node2 = new Node<Integer>(2, node3);
        Node<Integer> node1 = new Node<Integer>(1, node2);

        Node<Integer> newNode1 = NodeOperations.reverseNodeList(node1);
        int result1 = newNode1.getValue();
        int result2 = newNode1.getNextNode().getValue();
        int result3 = newNode1.getNextNode().getNextNode().getValue();
        assertThat(result1, is(3));
        assertThat(result2, is(2));
        assertThat(result3, is(1));
    }
    /**
     * If 1 incoming node should stay it unchanged.
     */
    @Test
    public void when1ElementInAListShouldStayTheSame() {
        Node<Integer> node1 = new Node<Integer>(1, null);
        Node<Integer> newNode1 = NodeOperations.reverseNodeList(node1);
        int result1 = newNode1.getValue();
        System.out.println(newNode1);
        assertThat(result1, is(1));
    }

}