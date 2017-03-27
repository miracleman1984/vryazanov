package ru.vryazanov.bank;

/**
 * User class that stores unique properties and methods for all users.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 26.03.2017
 */
public class User {
    /**
     * Store passport number of the user.
     */
    private long passport;
    /**
     * Store name of the user.
     */
    private String name;
    /**
     * User class constructor.
     *
     * @param passport  number of the user.
     * @param name of the user.
     */
    public User(long passport, String name) {
        this.passport = passport;
        this.name = name;
    }
    /**
     * Return passport number of the user.
     *
     * @return passport number of the user.
     */
    public long getPassport() {
        return passport;
    }
    /**
     * Set passport number of the user.
     *
     * @param passport number of the user.
     */
    public void setPassport(long passport) {
        this.passport = passport;
    }
    /**
     * Return name of the user.
     *
     * @return name of the user.
     */
    public String getName() {
        return name;
    }
    /**
     * Set name  for the user.
     *
     * @param name for the user.
     */
    public void setName(String name) {
        this.name = name;
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
        return passport == user.passport;
    }

    @Override
    public int hashCode() {
        return (int) (passport ^ (passport >>> 32));
    }
}
