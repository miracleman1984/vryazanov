package ru.vryazanov.tasks5.tree;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SearchBinaryTreeTest class
 * <p>
 * Class that checks SearchBinaryTree class.
 *
 * @author vryazanov
 * @version 1.0
 * @since 30.05.2017
 */
public class SearchBinaryTreeTest {
    /**
     * Testing adding elements to the tree.
     */
    @Test
    public void whenAdd3EleemntsThenLenequals4() {
        SearchBinaryTree<Integer> tree = new SearchBinaryTree<Integer>(11);
        tree.add(8);
        tree.add(14);
        tree.add(10);
        assertThat(tree.getLen(), is(4));
    }

    /**
     * Testing Finding Existing Element.
     */
    @Test
    public void whenTryingToFindExistingElementThenTrue() {
        SearchBinaryTree<Integer> tree = new SearchBinaryTree<Integer>(11);
        tree.add(8);
        tree.add(14);
        tree.add(10);
        tree.add(12);
        assertThat(tree.find(12), is(true));
    }

    /**
     * Testing Finding Non Existing Element.
     */
    @Test
    public void whenTryingToFindNonExistingElementThenFalse() {
        SearchBinaryTree<Integer> tree = new SearchBinaryTree<Integer>(11);
        tree.add(8);
        tree.add(14);
        tree.add(10);
        tree.add(12);
        assertThat(tree.find(5), is(false));
    }

}