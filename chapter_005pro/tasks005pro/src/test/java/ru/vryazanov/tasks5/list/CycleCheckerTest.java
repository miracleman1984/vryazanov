package ru.vryazanov.tasks5.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CycleChecker class
 * <p>
 * Class that checks node sequence for cycle.
 *
 * @author vryazanov
 * @version 1.0
 * @since 25.04.2017
 */
public class CycleCheckerTest {
    /**
     * If Four Nodes With Cycle Then Should Be True.
     */
    @Test
    public void whenFourNodesWithCycleThenShouldBeTrueThenShouldBeTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);
        CycleChecker check = new CycleChecker();
        boolean result = check.hasCycle(first);
        assertThat(result, is(true));
    }
    /**
     * If No Cycle But There Is a Zero insequence.
     */
    @Test
    public void whenNoCycleButThereIsZeroThenFalse() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(null);
        CycleChecker check = new CycleChecker();
        boolean result = check.hasCycle(first);
        assertThat(result, is(false));
    }

}