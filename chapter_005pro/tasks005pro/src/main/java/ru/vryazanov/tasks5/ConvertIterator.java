package ru.vryazanov.tasks5;

import java.util.Iterator;

/**
 * Interface  ConvertIterator.
 * <p>
 * Convert inner iterators to a single iterator.
 *
 * @author vryazanov
 * @version 1.0
 * @since 05.04.2017
 */
public interface ConvertIterator {
    /**
     * Convert inner iterators to a single iterator.
     *
     * @param it inner iterators
     * @return single iterator
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
