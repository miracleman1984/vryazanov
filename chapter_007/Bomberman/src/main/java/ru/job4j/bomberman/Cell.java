package ru.job4j.bomberman;

/**
 * Created by vvryazanov on 15.12.2017.
 */
public class Cell {
    /**
     * X coordinate of this unit on the board
     */
    private int xCoord;
    /**
     * Y coordinate of this unit on the board
     */
    private int yCoord;

    public Cell(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "xCoord=" + yCoord +
                ", yCoord=" + xCoord +
                '}';
    }
}
