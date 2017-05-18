package ru.vryazanov.tasks5.tree;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by vr on 14.05.2017.
 */
public class Tree1Test {

    public static final class User implements Comparable<User> {
        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return -this.name.compareTo(o.name);
        }
    }

    @Test
    public void add() {
        TreeSet<User> users = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        TreeMap<User, String> map;

        users.add(new User("pert"));
        users.add(new User("arsentev"));

        for (User user: users) {
            System.out.println(user.name);
        }
    }

}
