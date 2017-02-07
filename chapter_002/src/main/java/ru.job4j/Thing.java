package ru.job4j;

/**
 * Thing class stores characteristics of something and things that it can do.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 06.02.2017
 * @version 1
 */
public class Thing {
    /**
     * Store type of the thing.
     */
    private String type;
    /**
     * Store date that was last serving of thing.
     */
    private long lastServeDate;
    /**
     * Store current property of the thing.
     */
    private boolean isBroken;
    /**
     * Thing class constructor.
     * @param type type of the thing
     * @param lastServeDate date that was last serving of thing.
     * @param isBroken current property of the thing true if broken false if ok
     */
    public Thing(String type, long lastServeDate, boolean isBroken) {
        this.type = type;
        this.lastServeDate = lastServeDate;
        this.isBroken = isBroken;
    }
}
