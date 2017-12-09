package ru.job4j.bomberman;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class  Unit.
 * <p>
 * Class with unit logic
 *
 * @author vryazanov
 * @version 1.0
 * @since 09.12.2017
 */
public class Unit extends Thread {
    /**
     * Represent for current unit game board
     */
    private ReentrantLock[][] board;
    /**
     * X coordinate of this unit on the board
     */
    private int xCoord;
    /**
     * Y coordinate of this unit on the board
     */
    private int yCoord;
    /**
     * Is this unit thread have to be stopped
     */
    private boolean isStopped;

    /**
     * Unit constructor
     *
     * @param name   of the unit
     * @param xCoord oordinate of this unit on the board
     * @param yCoord oordinate of this unit on the board
     * @param board  represent for current unit game board
     */
    public Unit(String name, int xCoord, int yCoord, ReentrantLock[][] board) {
        this.setName(name);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.board = board;
        this.isStopped = false;
    }

    /**
     * Generate a new random coordinate by the parametrs
     *
     * @param current    coordinate
     * @param lowBound   of coordinate
     * @param upperBound of coordinate
     * @param maxChange  max step from the current coordinate
     * @return a new random coordinate
     */
    private int generateNewCoordinate(int current, int lowBound, int upperBound, int maxChange) {
        int origin = -maxChange;
        if (current - maxChange - lowBound < 0) {
            origin = lowBound - current;
        }
        int bound = maxChange;
        if (upperBound - current - maxChange < 0) {
            bound = upperBound - current;
        }
        int change = ThreadLocalRandom.current().nextInt(origin, bound + 1);
        return current + change;
    }

    /**
     * Set stopped flag
     *
     * @param stopped flag
     */
    public synchronized void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    @Override
    public void run() {
        while (!isStopped) {
            int newX = xCoord;
            int newY = yCoord;
            while ((newX - xCoord) == 0 && (newY - yCoord) == 0) {
                System.out.println(Thread.currentThread().getName() + " generate new coords");
                newX = generateNewCoordinate(xCoord, 0, board.length - 1, 1);
                newY = generateNewCoordinate(yCoord, 0, board[0].length - 1, 1);
            }
            xCoord = newX;
            yCoord = newY;
            System.out.println(Thread.currentThread().getName() + " newX = " + xCoord + " newY = " + yCoord);
            try {
                if (board[newX][newY].tryLock(500, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " acqired the cell X = " + newX + " Y = " + newY + " ... waiting for 1s ");
                    //если да, то ждем 1000мс
                    try {
                        Thread.currentThread().sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        board[newX][newY].unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed acqired the cell X = " + newX + " Y = " + newY + " ... regenerating new coords ");
                    while ((newX - xCoord) == 0 && (newY - yCoord) == 0) {
                        System.out.println(Thread.currentThread().getName() + " generate new coords");
                        newX = generateNewCoordinate(xCoord, 0, board.length - 1, 1);
                        newY = generateNewCoordinate(yCoord, 0, board[0].length - 1, 1);
                    }
                    xCoord = newX;
                    yCoord = newY;
                    System.out.println(Thread.currentThread().getName() + " newX = " + xCoord + " newY = " + yCoord);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " has just stop playing.");
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
