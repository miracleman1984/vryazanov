package ru.job4j.MonitorySynchronizy;

import net.jcip.annotations.GuardedBy;

/**
 * Class  User.
 * <p>
 * Class that descibes user properties
 *
 * @author vryazanov
 * @version 1.0
 * @since 11.09.2017
 */
public class User {
    /**
     * Store unique user id.
     */
    private int id;
    /**
     * Store  amount of money on user account.
     */
    private int amount;

    /**
     * User constructor.
     *
     * @param id     unique user id
     * @param amount initial amount of money on user account.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Return user id.
     * @return user id
     */
    public int getId() {
        return id;
    }

    /**
     * Return user amount of money.
     * @return user id
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Change amount of money on user account.
     * @param diff different between current and future amount state on user account (maybe  +-)
     * @return result of this operation true if succeded and false if not
     * @throws NoMoneyOnAccount if no money on account
     */
    @GuardedBy("this")
    public synchronized boolean changeAmount(int diff) throws NoMoneyOnAccount {
        boolean result = false;
        System.out.println(getAmount() + " " + diff);
        if (diff < 0 && amount < -diff) {
            throw new NoMoneyOnAccount("No such money on account: " + Thread.currentThread().getName() + "  " + getAmount());
        } else {
            this.amount += diff;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "User{"
                + "id="
                + id
                + ", amount="
                + amount
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
