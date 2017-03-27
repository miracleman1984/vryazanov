package ru.vryazanov.tasks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class  UserConvert.
 *
 * @author vryazanov
 * @version 1.0
 * @since 22.03.2017
 */
public class UserConvertTest {
    /**
     * If Converts List of users to HashMap.
     */
    @Test
    public void whenConvertListOfUserToHashMapByIdThenMapShouldFormsAsExpected() {
        List<User> list = new ArrayList<User>();
        User user1 = new User(1, "Vitaly", 20, "SPB");
        User user2 = new User(2, "Vital", 25, "SP");
        User user3 = new User(3, "Vita", 30, "S");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        HashMap<Integer, User> answers = UserConvert.process(list);
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        result.put(1, user1);
        result.put(2, user2);
        result.put(3, user3);
        assertThat(answers, is(result));
    }

}

