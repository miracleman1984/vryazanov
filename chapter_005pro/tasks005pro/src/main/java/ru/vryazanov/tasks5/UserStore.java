package ru.vryazanov.tasks5;

/**
 * Class  UserStore.
 * <p>
 * Container class for user objects.
 *
 * @author vryazanov
 * @version 1.0
 * @since 10.04.2017
 */
public class UserStore implements Store<User> {
    /**
     * Store user objects.
     */
    private SimpleList<User> userList;
    /**
     * UserStore constructor.
     *
     * @param size initial size of the container
     */
    public UserStore(int size) {
        this.userList = new SimpleList<User>(size);
    }
    @Override
    public void add(User user) {
        this.userList.add(user);
    }
    @Override
    public void update(User oldUser, User newUser) {
        this.userList.update(oldUser, newUser);
    }
    @Override
    public void delete(User user) {
        this.userList.delete(user);
    }
    @Override
    public User get(int position) {
        return userList.get(position);
    }
}
