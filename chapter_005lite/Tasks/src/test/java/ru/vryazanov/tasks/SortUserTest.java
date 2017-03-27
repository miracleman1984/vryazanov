package ru.vryazanov.tasks;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class  SortUser.
 *
 * @author vryazanov
 * @version 1.0
 * @since 22.03.2017
 */
public class SortUserTest {
    /**
     * If sort users by their age in ascening order.
     */
    @Test
    public void whenDesceningOrderThenMakeItAscening() {
        List<User> list = new ArrayList<User>();
        User user1 = new User(1, "Vitaly", 30, "SPB");
        User user2 = new User(2, "Vital", 29, "SPB");
        User user3 = new User(3, "Vita", 28, "SPB");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        Set<User> set = SortUser.sort(list);
        Set<User> result = new TreeSet<User>();
        result.add(user1);
        result.add(user2);
        result.add(user3);
        assertThat(set, is(result));
    }

    /**
     * If sort users by their name lenght in ascening order.
     */
    @Test
    public void whenSotingByNameLenghtThenMakeItAscening() {
        List<User> list = new ArrayList<User>();
        User user1 = new User(1, "Vitaly", 30, "SPB");
        User user2 = new User(2, "Vital", 29, "SPB");
        User user3 = new User(3, "Vitadfjklsg;", 28, "SPB");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        List<User> result = new ArrayList<User>();
        result.add(user2);
        result.add(user1);
        result.add(user3);
        assertThat(SortUser.sortLength(list), is(result));
    }

    /**
     * If sort users by their hashcode in ascening order.
     */
    @Test
    public void whenSortingByHashcodeThenMakeItAscening() {
        List<User> list = new ArrayList<User>();
        User user1 = new User(1, "Vitaly", 30, "SPB");
        User user2 = new User(2, "Vital", 29, "SPB");
        list.add(user1);
        list.add(user2);
        List<User> result = new ArrayList<User>();
        if (user1.hashCode() < user2.hashCode()) {
            result.add(user1);
            result.add(user2);
        } else {
            result.add(user2);
            result.add(user1);
        }
        assertThat(SortUser.sortHash(list), is(result));
    }
}
