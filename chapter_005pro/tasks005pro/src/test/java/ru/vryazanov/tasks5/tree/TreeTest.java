package ru.vryazanov.tasks5.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TreeTest class
 * <p>
 * Class that checks Tree class.
 *
 * @author vryazanov
 * @version 1.0
 * @since 18.05.2017
 */
public class TreeTest {
    /**
     * Testing creating container.
     */
    @Test
    public void whenCreateATreeThenLenShouldBeOne() {

        Tree<String> tree = new Tree<String>("1");
        assertThat(tree.getLen(), is(1));
    }
    /**
     * Testing adding 2elements to 1 node.
     */
    @Test
    public void whenAddTwoElementsToOneNodeThenLenShouldBeThreeElements() {
        Tree<String> tree = new Tree<String>("1");
        assertThat(tree.getLen(), is(1));
        boolean add1 = tree.add("1", "11");
        boolean add2 = tree.add("1", "12");
        assertThat(tree.getLen(), is(3));
        assertThat(add1, is(true));
        assertThat(add2, is(true));
    }
    /**
     * Testing adding new element and no such parent in the tree.
     */
    @Test
    public void whenAddElementAndNoParentInTreeThenNoAdding() {
        Tree<String> tree = new Tree<String>("1");
        assertThat(tree.getLen(), is(1));
        tree.add("1", "11");
        tree.add("11", "111");
        tree.add("11", "112");
        tree.add("1", "12");
        tree.add("12", "121");
        tree.add("12", "122");
        boolean add = tree.add("9", "123");
        assertThat(tree.getLen(), is(7));
        assertThat(add, is(false));
    }
}