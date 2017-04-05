package ru.vryazanov.tasks5;

import java.util.Iterator;

/**
 * Created by vr on 04.04.2017.
 */
public interface convertIterator {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
