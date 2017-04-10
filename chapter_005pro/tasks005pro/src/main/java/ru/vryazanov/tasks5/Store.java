package ru.vryazanov.tasks5;

/**
 * Interface Store.
 * <p>
 * Interface for object Stores. Object are need to be extended from Base class
 *
 * @author vryazanov
 * @version 1.0
 * @since 10.04.2017
 * @param <T> interface are need to be implemented to Stores for classes that extends Base class
 */
public interface Store<T extends Base> {
    /**
     * Add new item to the store.
     *
     * @param newItem that should be added
     */
    void add(T newItem);
    /**
     * Change element on the position by the value.
     *
     * @param oldItem that should be changed
     * @param newItem new value
     */
    void update(T oldItem, T newItem);
    /**
     * Delete element in the array by the value.
     *
     * @param item that should be deleted
     */
    void delete(T item);
    /**
     * Return element on the position.
     *
     * @param position of array to be returned
     * @return element on the position.
     */
    T get(int position);
}
