package ru.job4j.MonitorySynchronizy;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;


import java.util.HashSet;
import java.util.Iterator;
/**
 * Class  UserStorage.
 * <p>
 * Class that contains user accounts and makes operations with them.
 *
 * @author vryazanov
 * @version 1.0
 * @since 11.09.2017
 */
@ThreadSafe
public final class UserStorage {
    /**
     * Internal storage for user accounts.
     */
    private HashSet<User> users;

    /**
     * UserStorage constructor.
     */
    public UserStorage() {
        this.users = new HashSet<User>();
    }

    /**
     * Return user by its id.
     *
     * @param id user id
     * @return user with such id
     */
    @GuardedBy("users")
    //если не нашли пользователя - вернули null
    public User getUser(int id) {
        User result = null;
        synchronized (users) {
            for (User currentUser : users) {
                if (currentUser.getId() == id) {
                    result = currentUser;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Add new user to the storage.
     *
     * @param user to add
     * @return result of this operation true if succeded and false if not
     */
    @GuardedBy("users")
    public boolean add(User user) {
        synchronized (users) {
            return users.add(user);
        }
    }

    /**
     * Update user account in the  storage.
     *
     * @param id user id to update
     * @param diff amount to change user account
     * @return result of this operation true if succeded and false if not
     * @throws NoMoneyOnAccount if no money on account
     * @throws NoUserException if no such user in storage
     */
    @GuardedBy("users")
    public boolean update(int id, int diff) throws NoUserException, NoMoneyOnAccount {
        boolean result = false;
        synchronized (users) {
            User user = this.getUser(id);
            if (user == null) {
                result = false;
                throw new NoUserException("No such user " + id);
            } else {
                result = user.changeAmount(diff);
            }
        }
        return result;
    }

    /**
     * Update user account in the  storage.
     *
     * @param id user id to update
     * @return result of this operation true if succeded and false if not
     */
    @GuardedBy("users")
    public boolean delete(int id) {
        boolean result = false;
        synchronized (users) {
            Iterator<User> userIterator = users.iterator();
            while (userIterator.hasNext()) {
                if (userIterator.next().getId() == id) {
                    userIterator.remove();
                    result = true;
                    break;
                }
            }
        }
        if (!result) {
            try {
                throw new NoUserException("No such user to delete");
            } catch (NoUserException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Update money from one user account to another.
     *
     * @param fromId user whose account will be decreased
     * @param toId user whose account will be increased
     * @param amount of money to transfer
     * @return result of this operation true if succeded and false if not
     */
    @GuardedBy("users")
    public boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        synchronized (users) {
            try {
                result = update(fromId, -amount);
            } catch (NoUserException e) {
                e.printStackTrace();
            } catch (NoMoneyOnAccount noMoneyOnAccount) {
                System.out.println("No such money on FROM account");
                noMoneyOnAccount.printStackTrace();
            }
            if (!result) {
                try {
                    update(toId, amount);
                } catch (NoUserException e) {
                    e.printStackTrace();
                } catch (NoMoneyOnAccount noMoneyOnAccount) {
                    System.out.println("No such money on TO account");
                    noMoneyOnAccount.printStackTrace();
                }
            }
        }
        return result;
    }
}
