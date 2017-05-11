package ru.vryazanov.tasks5.map;

import java.util.Iterator;

/**
 * ImprovedSet class
 * <p>
 * Some class that can demonstrate set with hashtables.
 *
 * @param <T> any type of the generic
 * @param <V> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 11.05.2017
 */
public class Dict<T, V> implements Iterable<T> {
    /**
     * Store a proportion of current number of elements to length of the table when length of the table should be increased.
     */
    static final float LOAD_FACTOR = 0.3f;
    /**
     * Store current number of items in table.
     */
    private int size = 0;
    /**
     * Store internal massive of Nodes (hashtable).
     */
    private Node<T, V>[] table;

    /**
     * Dict  constructor.
     *
     * @param initialLength initial size of hashtable
     */
    public Dict(int initialLength) {
        this.table = new Node[initialLength];
    }

    /**
     * Hash function of a key.
     *
     * @param key item for hashing
     * @return hash.
     */
    int hash(T key) {
        return key.hashCode() % table.length;
    }

    /**
     * Insert item to the table.
     *
     * @param key   item for inserting
     * @param value item for inserting
     * @return result of the operation true if successful and false otherwise.
     */
    boolean insert(T key, V value) {
        boolean result = false;
        //нахождение хэшкода key
        //определение позиции в массиве
        int i = hash(key);
        //проверка есть ли элемент на этой позиции
        //вставка элемента на позицию, если она пустая
        if (table[i] == null) {
            result = true;
            table[i] = new Node<T, V>(key.hashCode(), key, value);
            size++;
            //если отношение размера массива к количеству элементов превысило
            //некое пороговое значение - изменить размер массива и перехэшировть его
            if ((float) size / table.length > LOAD_FACTOR) {
                resize();
            }
        }
        return result;
    }

    /**
     * Get item from the table.
     *
     * @param key item for searching
     * @return value that corresponds to given key.
     */
    V get(T key) {
        return table[hash(key)].value;
    }

    /**
     * Delete item from the table.
     *
     * @param key item for deleting
     * @return result of the operation true if successful and false otherwise.
     */
    boolean delete(T key) {
        if (table[hash(key)] != null) {
            table[hash(key)] = null;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Resize and rehash table.
     */
    private void resize() {
        //записать старую таблицу в отдельный массив
        Node<T, V>[] oldTable = table;
        //умножить текущий размер массива на 2  и найти следующее простое число
        int newLength = findNextPrime(2 * table.length);
        //создать новый массив и присвоить его встроенной таблице
        table = new Node[newLength];
        //добавить элементы из старого массива с новыми хэшами
        size = 0;
        for (Node<T, V> node : oldTable) {
            if (node != null) {
                insert(node.key, node.value);
            }
        }
    }

    /**
     * Find next prime number.
     *
     * @param newLength a number from that we will start searching
     * @return next prime number.
     */
    private int findNextPrime(int newLength) {
        boolean findPrime = true;
        for (int i = newLength + 1;; i++) {
            findPrime = true;
            for (int j = 2; j <= Math.sqrt(i) + 1; j++) {
                if (i % j == 0) {
                    findPrime = false;
                    break;
                }
            }
            if (findPrime) {
                return i;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new Dict<T, V>.Itr();
    }

    /**
     * Itr class
     * <p>
     * Class that defining internal iterator.
     */
    public class Itr implements Iterator {
        /**
         * Store current item to iterate.
         */
        private int nodeIndex = 0; //текущий элемент
        /**
         * Store initial number of items.
         */
        private int iteratorSize = size;
        /**
         * Store current position in table.
         */
        private int tableIndex = 0;

        @Override
        public boolean hasNext() {
            return nodeIndex < iteratorSize;
        }

        @Override
        public T next() {
            while (tableIndex < table.length && table[tableIndex] == null) {
                tableIndex++;
            }
            nodeIndex++;
            return table[tableIndex++].key;
        }

        @Override
        public void remove() {
            table[tableIndex - 1] = null;
            size--;
        }
    }

    /**
     * Node class
     * <p>
     * Class that contains hash, key and value.
     *
     * @param <T> any type of the generic
     * @param <V> any type of the generic
     */
    private class Node<T, V> {
        /**
         * Store hash of the key.
         */
        private int hash;
        /**
         * Store key.
         */
        private T key;
        /**
         * Store internal value.
         */
        private V value;
        /**
         * Node constructor.
         *
         * @param hash set hash for the node
         * @param key set key for the node
         * @param value set value for the node
         */
        Node(int hash, T key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "key = " + key + " value = " + value;
        }
    }
    /**
     * Return current length of the table.
     *
     * @return current length of the table.
     */
    public int getLength() {
        return table.length;
    }
    /**
     * Return current number of nodes in the table.
     *
     * @return current number of nodes in the table..
     */
    public int getSize() {
        return size;
    }
}


