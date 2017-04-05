package ru.vryazanov.tasks5;

import java.util.Iterator;

/**
 * Class  NewIterator.
 * <p>
 * Some class that can convert iterators.
 *
 * @author vryazanov
 * @version 1.0
 * @since 02.04.2017
 */
public class NewIterator implements ConvertIterator {

    /**
     * Convert inner iterators to a single iterator.
     *
     * @param it inner iterators
     * @return single iterator
     */
    public Iterator<Integer> convert(final Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {
            //массив, по которому мы проходим
            private Iterator<Iterator<Integer>> values = it;
            //текущий курсор = текущий итератор
            private Iterator<Integer> currentIterator = values.next();

            public boolean hasNext() {
                // если в текущем итераторе нет больше позиций, то проверяем есть ли еще итераторы
                return currentIterator.hasNext() ? true : values.hasNext();
            }

            public Integer next() {
                //если закончились позиции в currentIterator - сменить currentIterator, если они еще остались,
                // если нет - то ничего не делать
                if (!currentIterator.hasNext()) {
                    if (values.hasNext()) {
                        currentIterator = values.next();
                    }
                }
                return currentIterator.next();
            }

            public void remove() {

            }
        };
    }
}

