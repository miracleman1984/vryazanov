package ru.vryazanov.tasks5.tree;

/**
 * Interface SimpleTree.
 * <p>
 * Interface for object Trees. Object are need to be comparable. Trees must be Iterable/
 *
 * @param <E> generics that will be inserted as elements
 * @author vryazanov
 * @version 1.0
 * @since 18.05.2017
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return result of the operation. True if succeed, false otherwise.
     */
    boolean add(E parent, E child);
}
