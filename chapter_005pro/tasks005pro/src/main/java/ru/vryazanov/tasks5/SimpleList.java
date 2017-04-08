package ru.vryazanov.tasks5;

/**
 * SimpleList class
 * <p>
 * Some class that can denonstrate container as a array with generalize types.
 *
 * @param <T> any type of the generic
 * @author vryazanov
 * @version 1.0
 * @since 08.04.2017
 */
public class SimpleList<T> {
    /**
     * Store internal massive of objects.
     */
    private Object[] objects;
    /**
     * Store curent lenght of the array.
     */
    private int index = 0;

    /**
     * EvenIterator constructor.
     *
     * @param size initial size of the array
     */
    public SimpleList(int size) {
        this.objects = new Object[size];
    }

    /**
     * Add new element into the array.
     * And move forward the pointer (index)
     *
     * @param value adding value
     */
    public void add(T value) {
        this.objects[index++] = value;
    }

    /**
     * Return element on the position.
     *
     * @param position of array to be returned
     * @return element on the position.
     */
    public T get(int position) {
        return (T) this.objects[position - 1];
    }

    /**
     * Change element on the position by the value.
     *
     * @param position of array to be changed
     * @param newValue new value
     */
    public void update(int position, T newValue) {
        this.objects[position - 1] = newValue;
    }

    /**
     * Delete element in the array by the value.
     *
     * @param value that should be deleted
     */
    public void delete(T value) {
        //todo: delete all objects with this value
        for (int i = 0; i < index; i++) {
            if (this.objects[i].equals(value)) {
                System.arraycopy(this.objects, i + 1, this.objects, i, this.objects.length - i - 1);
                index--;
            }
        }
    }
    /**
     * Delete element in the array by the position.
     *
     * @param position on which we should delete a value
     */
    public void delete(int position) {
        //todo: delete object on the position
        System.arraycopy(this.objects, position, this.objects, position - 1, this.objects.length - position);
        index--;
    }
    /**
     * Return current length of the array.
     *
     * @return  current length of the array
     */
    public int getIndex() {
        return index;
    }
}
