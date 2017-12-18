package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vvryazanov on 13.12.2017.
 */
public class Block{
    /**
     * X coordinate of this unit on the board
     */
    private int xCoord;
    /**
     * Y coordinate of this unit on the board
     */
    private int yCoord;

    public Block(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    /**
     * Return x coordanate of the unit.
     *
     * @return x coordanate of the unit
     */
    public int getxCoord() {
        return xCoord;
    }

    /**
     * Return y coordanate of the unit.
     *
     * @return y coordanate of the unit
     */
    public int getyCoord() {
        return yCoord;
    }
}
