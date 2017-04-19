package ru.vryazanov.tasks5.list;

import java.util.Iterator;

/**
 * DynamicLinkedList class
 * <p>
 * Some class that can denonstrate container on linked values array with generalize types.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 19.04.2017
 */

public class DynamicLinkedList<E> implements Iterable<E> {
    /**
     * Store first element of list.
     */
    private Node<E> first;
    /**
     * Store last element of list.
     */
    private Node<E> last;
    /**
     * Store current size of list.
     */
    private int size = 0;

    /**
     * Add new element into the list.
     * And increase the size
     *
     * @param value adding value
     */
    public void add(E value) {
        //создаем новую ноду
        Node<E> newNode = new Node<E>(value, last, null);
        //если последней ячйки не существовало (null) - значит это первое добавление
        //присваиваем первой и последней ячейкам одно и то же значение
        //если обычное добавление - прежний последний элемент теперь ссылается на добавляемый элемент
        //а добавляемый элемент становится последним
        if (last == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * Return element on the position.
     *
     * @param index of array to be returned
     * @return element on the position.
     */
    public E get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = first;
        int count = 1;
        while (count != index) {
            current = current.next;
            count++;
        }
        return current.item;
    }

    /**
     * Internal iterator.
     *
     * @return internal iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> currentNode = first;
            private Node<E> previousNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                E result = currentNode.item;
                previousNode = currentNode;
                currentNode = currentNode.next;
                return result;
            }
            //удаляет текущий элемент - он существует
            @Override
            public void remove() {
                // если последний элемент - у предпоследнего элемента зануляем следующий и объявляем его последним
                if (!hasNext()) {
                    previousNode.next = null;
                    last = previousNode;
                    previousNode = previousNode.previous;
                } else {
                    previousNode = previousNode.previous;
                    previousNode.next = currentNode;
                    currentNode.previous = previousNode;
                }
                size--;
            }
        };
    }

    /**
     * Node class
     * <p>
     * Class that contains value and point to the certain next and previous nodes.
     *
     * @param <E> any type of the generic
     */
    private class Node<E> {
        /**
         * Store internal value.
         */
        private E item;
        /**
         * Store previous node of the list.
         */
        private Node<E> previous;
        /**
         * Store next node of the list.
         */
        private Node<E> next;
        /**
         * Node constructor.
         * @param item set value for the node
         * @param next set next node of the list
         * @param previous set previous node of the list
         */
        Node(E item, Node<E> previous, Node<E> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    /**
     * Return current size of array.
     *
     * @return current size of array.
     */
    public int size() {
        return size;
    }
}
