package ru.vryazanov.tasks5.map;

import java.util.Calendar;

/**
 * Created by vr on 05.05.2017.
 */
public class User {
    public String name;
    public int children;
    public Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
