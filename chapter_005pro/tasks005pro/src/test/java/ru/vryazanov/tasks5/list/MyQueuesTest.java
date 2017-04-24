package ru.vryazanov.tasks5.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class MyQueues.
 *
 * @author vryazanov
 * @version 1.0
 * @since 24.04.2017
 */
public class MyQueuesTest {
    /**
     * If add to an empty Stack two elements tits size should be increased.
     */
    @Test
    public void whenAddNewElementToStackThenShouldBeAdded() {
        MyQueues<String> stack = new MyStack<String>();
        stack.push("One");
        stack.push("Two");
        assertThat(stack.size(), is(2));
    }
    /**
     * If delete elements from the Stack then should return from the botttom.
     */
    @Test
    public void whenDeleteFirstElementFromStackThenShouldBeDeleted() {
        MyQueues<String> stack = new MyStack<String>();
        stack.push("One");
        stack.push("Two");
        assertThat(stack.pop(), is("Two"));
        assertThat(stack.pop(), is("One"));
    }
    /**
     * If trying to delete element from the empty array then should be error.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryingToDeleteElementFromStackInEmptyArrayThenShouldBeError() {
        MyQueues<String> stack = new MyStack<String>();
        stack.push("One");
        stack.push("Two");
        stack.pop();
        stack.pop();
        stack.pop();
    }
    /**
     * If add to an empty array two elements its size should be increased.
     */
    @Test
    public void whenAddNewElementToQueueThenShouldBeAdded() {
        MyQueues<String> queues = new MyQueue<String>();
        queues.push("One");
        queues.push("Two");
        assertThat(queues.size(), is(2));
    }
    /**
     * If delete elements from the Queue then should return from the top.
     */
    @Test
    public void whenDeleteFirstElementFromQueueThenShouldBeDeleted() {
        MyQueues<String> queues = new MyQueue<String>();
        queues.push("One");
        queues.push("Two");
        assertThat(queues.pop(), is("One"));
        assertThat(queues.pop(), is("Two"));
    }
}