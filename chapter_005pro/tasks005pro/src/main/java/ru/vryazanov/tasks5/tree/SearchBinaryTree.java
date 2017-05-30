package ru.vryazanov.tasks5.tree;

/**
 * SearchBinaryTree class
 * <p>
 * Some class that can demonstrate SearchBinaryTree tree.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 30.05.2017
 */
public class SearchBinaryTree<E extends Comparable<E>> {
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
    public SearchBinaryTree(E rootElement) {
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
    private class Node<E extends Comparable<E>> {
        /**
         * Store internal value.
         */
        private E value;
        /**
         * Store left child node.
         */
        private Node<E> leftChild;
        /**
         * Store right child node.
         */
        private Node<E> rightChild;

        /**
         * Node constructor.
         *
         * @param value      set value for the node
         * @param leftChild  set left child for the node
         * @param rightChild set right child for the node
         */
        Node(E value, Node<E> leftChild, Node<E> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        /**
         * Node constructor.
         *
         * @param value set value for the node
         */
        Node(E value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        /**
         * Return value of the node.
         *
         * @return value of the node
         */
        public E getValue() {
            return value;
        }

        /**
         * Return left children of the node.
         *
         * @return left children of the node
         */
        public Node<E> getLeftChild() {

            return this.leftChild;
        }

        /**
         * Return right children of the node.
         *
         * @return right children of the node
         */
        public Node<E> getRightChild() {

            return this.rightChild;
        }

        /**
         * Add child to the node.
         *
         * @param child that need to be added
         */
        public void addChild(E child) {
            //Элемент слева от корня, меньше либо равен корню, а правый больше корня.
            //сравниваем добавляемый элемент и корень
            //если добавляемый элемент меньше корння - то добавляем его в левый
            if (child.compareTo(this.value) <= 0) {
                //если слева null - просто устанавливаем значение левой ноды
                if (this.getLeftChild() == null) {
                    this.leftChild = new Node<E>(child);
                } else {
                    //перед тем, как провалиться, мы сравниваем добавляемое значение с текущей нодой
                    //если значение меньше текщей ноды - проваливаемся
                    if (child.compareTo(this.getLeftChild().value) <= 0) {
                        this.getLeftChild().addChild(child);
                    } else {
                        //если значение все-таки больше текущей ноды, то
                        //создаем новую ноду, у которой значение добавляемой ноды, и левый потомок - текущая нода
                        this.leftChild = new Node<E>(child, this.leftChild, null);
                    }
                }
            } else {
                //если добавляемый элемент больше корня - то добавляем его в правый
                if (this.getRightChild() == null) {
                    this.rightChild = new Node<E>(child);
                } else {
                    this.getRightChild().addChild(child);
                }
            }
        }

        @Override
        public String toString() {
            return "Node{" + " value= " + value + " Left child value: " + leftChild
                    + " right child value: " + rightChild + '}';
        }
    }

    /**
     * Add new value to the tree.
     *
     * @param child that need to be added
     */
    public void add(E child) {
        len++;
        rootNode.addChild(child);
    }

    /**
     * Return length of the tree.
     *
     * @return node with that value or null if unsucceed.
     */
    public int getLen() {
        return len;
    }

    /**
     * Is this value in the tree.
     *
     * @param e value to find
     * @return true if this value in the tree and false otherwise
     */
    public boolean find(E e) {
        boolean result = false;
        Node<E> currentNode = rootNode;
        while (true) {
            if (e.compareTo(currentNode.value) == 0) {
                result = true;
                break;
            } else if (e.compareTo(currentNode.value) < 0) {
                //если слева null - прекращаем поиск
                if (currentNode.getLeftChild() == null) {
                    result = false;
                    break;
                }
                currentNode = currentNode.getLeftChild();
            } else if (e.compareTo(currentNode.value) > 0) {
                //если справа null - прекращаем поиск
                if (currentNode.getRightChild() == null) {
                    result = false;
                    break;
                }
                currentNode = currentNode.getRightChild();
            }
        }
        return result;
    }

}
