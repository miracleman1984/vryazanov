package ru.vryazanov.tasks5.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by vr on 05.05.2017.
 */
public class UserTest {


    @Test
    public void map() {
        Calendar date1 = Calendar.getInstance();
        date1.set(1984,11,5);
        User user1 = new User("Vitaly", 2, date1);
        User user2 = new User("Vitaly", 2, date1);
        Map<User, Object> map = new HashMap<User, Object>();
        map.put(user1, "first");
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        map.put(user2, "second");
        System.out.println(map);
    }


}