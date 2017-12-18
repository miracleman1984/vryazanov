package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vvryazanov on 13.12.2017.
 */
public class Monster extends Unit{

    /**
     * Unit constructor
     *
     * @param name   of the unit
     * @param xCoord oordinate of this unit on the board
     * @param yCoord oordinate of this unit on the board
     * @param board  represent for current unit game board
     */
    public Monster(String name, int xCoord, int yCoord, Game game) {
        super(name, xCoord, yCoord, game, true);
    }



}
