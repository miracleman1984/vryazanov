package ru.vryazanov.tasks5.set;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * SimpleSet class
 * <p>
 * Some class that can demonstrate set.
 *
 * @param <E> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 26.04.2017
 */
public class LinkedSimpleSet<E> implements MySet<E> {
    /**
     * Store internal massive of objects.
     */
    private LinkedList<E> objects;

    /**
     * SimpleSet dafault constructor.
     */
    public LinkedSimpleSet() {
        this.objects = new LinkedList<E>();
    }
    /**
     * Testing is element already is in the internal array.
     *
     * @param e item for testing
     * @return true if element already in the array and false otherwise.
     */
    public boolean duplicateTest(E e) {
        boolean result = false;
        for (Object object : objects) {
            if (object.equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Add new element into the array.
     * And move forward the pointer (index)
     *
     * @param e adding value
     */
    public void add(E e) {
        if (!duplicateTest(e)) {
            this.objects.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return objects.iterator();
    }


    /**
     * Return current size of array.
     *
     * @return current size of array.
     */
    public int size() {
        return objects.size();
    }
}
