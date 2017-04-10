package ru.vryazanov.tasks5;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class  Store.
 *
 * @author vryazanov
 * @version 1.0
 * @since 10.04.2017
 */
public class StoreTest {
    /**
     * Store user array for testing.
     */
    private Store<User> userStore = new UserStore(10);
    /**
     * Store role array for testing.
     */
    private Store<Role> roleStore = new RoleStore(10);
    /**
     * Before each test preparing arrays.
     */
    @Before
    public void setUp() {
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("2");
        User user4 = new User("4");
        Role role1 = new Role("1");
        Role role2 = new Role("2");
        Role role3 = new Role("2");
        Role role4 = new Role("4");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        userStore.add(user4);
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        roleStore.add(role4);
    }
    /**
     * If compare items that should be equal.
     */
    @Test
    public void whenCompareBaseItemsWithTheSameIdThenShouldBeEqual() {
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("2");
        assertThat(user2.equals(user3), is(true));
        assertThat(user1.equals(user2), is(false));
    }
    /**
     * If add new items.
     */
    @Test
    public void whenAddNewItemThenSHouldReturnRight() {
        User user5 = new User("1");
        Role role5 = new Role("1");
        userStore.add(user5);
        roleStore.add(role5);
        assertThat(userStore.get(5), is(user5));
        assertThat(roleStore.get(5), is(role5));
    }
    /**
     * If update item by item id.
     */
    @Test
    public void whenUpdateItemsThenShouldReturnUpdatedItems() {
        User user1 = new User("2");
        User user5 = new User("5");
        Role role1 = new Role("2");
        Role role5 = new Role("5");
        userStore.update(user1, user5);
        roleStore.update(role1, role5);
        assertThat(userStore.get(2), is(user5));
        assertThat(userStore.get(3), is(user5));
        assertThat(roleStore.get(2), is(role5));
        assertThat(roleStore.get(3), is(role5));
    }
    /**
     * If delete items.
     */
    @Test
    public void whenDeleteItemsThenShouldntBeInStore() {
        User user1 = new User("2");
        User user4 = new User("4");
        Role role1 = new Role("2");
        Role role4 = new Role("4");
        userStore.delete(user1);
        roleStore.delete(role1);
        assertThat(userStore.get(2), is(user4));
        assertThat(roleStore.get(2), is(role4));
    }

}
