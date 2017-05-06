package ru.vryazanov.tasks5.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by vr on 05.05.2017.
 */
public class MapTest {
    public static final class User {
        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

    @Test
    public void map () {
        User first = new User("Petr");
        User second = new User("Petr");

        Map<User, String> map = new HashMap<User, String>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map.get(first));
        //assertThat(first, is(second));
    }



}
