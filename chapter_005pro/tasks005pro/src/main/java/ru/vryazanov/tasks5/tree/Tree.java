package ru.vryazanov.tasks5.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Tree class
 * <p>
 * Some class that can demonstrate simple tree.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 18.05.2017
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Store top element.
     */
    private Node<E> rootNode;
    /**
     * Store curent lenght of the tree.
     */
    private int len = 1;
    /**
     * Tree constructor.
     *
     * @param rootElement top element
     */
    public Tree(E rootElement) {
        this.rootNode = new Node<E>(rootElement);
    }
    /**
     * Node class
     * <p>
     * Element of the tree.
     * Class that contains value and children of the certain point in the tree.
     *
     * @param <E> any type of the generic
     */
    private class Node<E> {
        /**
         * Store internal value.
         */
        private E value;
        /**
         * Store list of children nodes.
         */
        private List<Node<E>> children;
        /**
         * Node constructor.
         *
         * @param value set value for the node
         */
        Node(E value) {
            this.value = value;
            this.children = new ArrayList<Node<E>>();
        }
        /**
         * Return value of the node.
         *
         * @return  value of the node
         */
        public E getValue() {
            return value;
        }
        /**
         * Return children of the node.
         *
         * @return  children of the node
         */
        public List<Node<E>> getChildren() {

            return children;
        }
        /**
         * Add child to the node.
         *
         * @param child that need to be added
         * @return result of the operation. True if succeed, false otherwise.
         */
        public boolean addChild(Node<E> child) {
            len++;
            return this.children.add(child);
        }

        @Override
        public String toString() {
            return "Node{" + " value= " + value + " |  Number of children: " + children.size() + '}';
        }
    }

    @Override
    public boolean add(E parent, E child) {
        Node<E> newNode = new Node<E>(child);
        Node<E> parentNode = null;
        parentNode = find(rootNode, parent);
        if (parentNode != null) {
            parentNode.addChild(newNode);
        }
        return parentNode == null ? false : true;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    /**
     * Find element from given node and lower.
     *
     * @param node starting node to serach
     * @param toFind element to find
     * @return node with that value or null if unsucceed.
     */
    public Node<E> find(Node<E> node, E toFind) {
        Node<E> result = null;
        //проверка значения текущей ноды
        if (node.getValue().compareTo(toFind) == 0) {
            result = node;
        } else {
            for (Node<E> noda : node.getChildren()) {
                result = find(noda, toFind);
                if (result != null) {
                    break;
                }
            }
        }
        return result;
    }
    /**
     * Return length of the tree.
     *
     * @return node with that value or null if unsucceed.
     */
    public int getLen() {
        return len;
    }

}
