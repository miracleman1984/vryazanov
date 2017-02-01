package ru.job4j;

/**
 * Created by vr on 31.01.2017.
 */
public class Thing {
    String type;
    long lastServeDate;
    boolean isBroken;

    public Thing(String type, long lastServeDate, boolean isBroken) {
        this.type = type;
        this.lastServeDate = lastServeDate;
        this.isBroken = isBroken;
    }
}
