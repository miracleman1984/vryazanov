package ru.vryazanov.tasks5.map;

import java.util.Calendar;

/**
 * Created by vr on 05.05.2017.
 */
public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
