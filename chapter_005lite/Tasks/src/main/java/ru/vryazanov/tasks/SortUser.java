package ru.vryazanov.tasks;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class  SortUser.
 * <p>
 * Methods for sorting users
 *
 * @author vryazanov
 * @version 1.0
 * @since 22.03.2017
 */
public class SortUser {
    /**
     * Sorts list of users by the inner class comparator.
     *
     * @param list to convert
     * @return sorted set of users
     */
    public static Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<User>();
        set.addAll(list);
        return set;
    }

    /**
     * Sorts list of users by the hashcode.
     *
     * @param list to sort
     * @return sorted list of users
     */
    public static List<User> sortHash(List<User> list) {
        //- в этом методе необходимо определить Comparator для метода Collections.sort
        // и отсортировать List<User> по hash-коду.
        Collections.sort(list,
                new Comparator<User>() {
                    public int compare(User o1, User o2) {
                        return o1.hashCode() - o2.hashCode();
                    }
                });
        return list;
    }

    /**
     * Sorts list of users by the name lenght.
     *
     * @param list to sort
     * @return sorted set of users
     */
    public static List<User> sortLength(List<User> list) {
        //- в этом методе необходимо определить Comparator для метода Collections.sort
        // и отсортировать List<User> по длине имени.
        Collections.sort(list,
                new Comparator<User>() {
                    public int compare(User o1, User o2) {
                        return o1.getName().length() - o2.getName().length();
                    }
                });
        return list;
    }
}
