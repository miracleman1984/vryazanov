package ru.job4j.bomberman;


import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class  Game.
 * <p>
 * Class with game logic
 *
 * @author vryazanov
 * @version 1.0
 * @since 09.12.2017
 */
public class Game {
    /**
     * Game board.
     */
    final private ReentrantLock[][] board;
    /**
     * Game units.
     */
    final private ArrayList<Unit> units = new ArrayList<Unit>();

    /**
     * Game constructor
     *
     * @param xSize board size
     * @param ySize board size
     */
    public Game(int xSize, int ySize) {
        this.board = new ReentrantLock[xSize][ySize];
        for (int a = 0; a < xSize; a++) {
            for (int b = 0; b < ySize; b++) {
                this.board[a][b] = new ReentrantLock();
            }
        }
    }

    /**
     * Main test method.
     *
     * @param args some args
     * @throws InterruptedException exeption on sleep
     */
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(3, 3);
        game.setHero("Vasya", 0, 0);
        game.setHero("Kolya", 2, 2);
        game.start();
        Thread.currentThread().sleep(10000);
        System.out.println("The game is ending...");
        game.stop();

    }

    /**
     * Stop the game
     */
    private void stop() {
        for (Unit unit : units) {
            unit.setStopped(true);
        }
    }

    /**
     * Set the hero on the game board
     *
     * @param name   of the hero
     * @param xCoord on the game board
     * @param yCoord on the game board
     * @throws InterruptedException if something goes wrong
     */
    private void setHero(String name, int xCoord, int yCoord) throws InterruptedException {
        for (Unit unit : units) {
            if (unit.getxCoord() == xCoord && unit.getyCoord() == yCoord) {
                throw new OccupiedCellException(String.format("%s was trying to occupy the with  X = %d and Y = %s, but %s already was here", name, xCoord, yCoord, unit.getName()));
            }
        }
        units.add(new Unit(name, xCoord, yCoord, board));
    }

    /**
     * Start the game
     */
    private void start() {
        for (Unit unit : units) {
            unit.start();
        }
    }
}
