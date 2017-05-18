package ru.vryazanov.tasks5.map;

import java.util.Calendar;

/**
 * Class  ManNoHashcode.
 * <p>
 * Class for ManNoHashcode objects.
 *
 * @author vryazanov
 * @version 1.0
 * @since 12.05.2017
 */
public class ManNoHashcode {
    /**
     * Store name of the man.
     */
    private String name;
    /**
     * Store number of children  of the man.
     */
    private int children;
    /**
     * Store birthday date of the man.
     */
    private Calendar birthday;

    /**
     * User constructor.
     *
     * @param name     of the man
     * @param children number of children  of the man
     * @param birthday birthday date of the man
     */
    public ManNoHashcode(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ManNoHashcode)) {
            return false;
        }

        ManNoHashcode anotherMan = (ManNoHashcode) o;
        if (this.name == anotherMan.name && this.birthday == anotherMan.birthday) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    /**
     * Set new number of children  of the man.
     *
     * @param children number of children  of the man
     */
    public void setChildren(int children) {
        this.children = children;
    }
}
