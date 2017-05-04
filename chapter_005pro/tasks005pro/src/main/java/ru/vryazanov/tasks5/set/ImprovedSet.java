package ru.vryazanov.tasks5.set;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * ImprovedSet class
 * <p>
 * Some class that can demonstrate set with hashtables.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 04.05.2017
 */
public class ImprovedSet<E> implements MySet<E> {
    /**
     * Store internal massive of LinkedLists (hashtable).
     */
    private LinkedList<E>[] hashArray; //массив ячеек хэш-таблицы
    /**
     * Store size of hashtable.
     */
    private int arraySize; // размер массива ячеек хэш-таблицы
    /**
     * Store curent lenght of the array.
     */
    private int size; //текущее количество элементов в сете

    /**
     * ImprovedSet  constructor.
     *
     * @param arraySize size of hashtable
     */
    public ImprovedSet(int arraySize) {
        this.arraySize = arraySize;
        this.size = 0;
        this.hashArray = new LinkedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new LinkedList<E>();
        }
    }

    /**
     * Testing is element already is in the internal arrayn.
     *
     * @param e       item for testing
     * @param hashVal current testing hashVal
     * @return true if element already in the array and false otherwise.
     */
    public boolean duplicateTest(E e, int hashVal) {
        boolean result = false;
        for (E some : hashArray[hashVal]) {
            if (some.equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public void add(E e) {

        int hashVal = Math.abs(e.hashCode() % arraySize);
        if (hashVal < 0) {
            System.out.println(e.hashCode());
        }
        if (!duplicateTest(e, hashVal)) {
            hashArray[hashVal].add(e);
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ImprovedSet<E>.Itr();
    }

    /**
     * Itr class
     * <p>
     * Class that defining internal iterator.
     */
    public class Itr implements Iterator<E> {
        /**
         * Store current index to iterate.
         */
        private int index = 0; //текущий элемент
        /**
         * Store current index of hashtable  to iterate.
         */
        private int linkedListIndex = 0;
        /**
         * Store current iterator of hashtable  to iterate.
         */
        private Iterator<E> currentIterator = hashArray[linkedListIndex].iterator();

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            E result = null;
            while (linkedListIndex < arraySize) {
                if (!currentIterator.hasNext()) {
                    linkedListIndex++;
                    currentIterator = hashArray[linkedListIndex].iterator();
                } else {
                    result = hashArray[linkedListIndex].iterator().next();
                    index++;
                    break;
                }
            }
            return result;
        }

        @Override
        public void remove() {
        }
    }
}
