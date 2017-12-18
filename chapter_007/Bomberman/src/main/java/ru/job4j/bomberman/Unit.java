package ru.job4j.bomberman;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public abstract class Unit extends Thread {
    /**
     * Represent for current unit game board
     */
    protected ReentrantLock[][] board;
    protected byte[][] boardWithBlocks;
    protected Game game;
    /**
     * X coordinate of this unit on the board
     */
    protected  int xCoord;
    /**
     * Y coordinate of this unit on the board
     */
    protected  int yCoord;
    /**
     * Is this unit thread have to be stopped
     */
    protected boolean isStopped;
    /**
     *
     */
    protected boolean autoMoving;
    /**
     * Unit constructor
     *
     * @param name   of the unit
     * @param xCoord oordinate of this unit on the board
     * @param yCoord oordinate of this unit on the board
     * @param board  represent for current unit game board
     */
    public Unit(String name, int xCoord, int yCoord, Game game, boolean autoMoving) {
        this.setName(name);
        this.game = game;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.board = game.getBoard();
        this.isStopped = false;
        this.autoMoving = autoMoving;
        this.boardWithBlocks = game.getBoardWithBlocks();
    }

    protected Cell genNextCell(int xCoord, int yCoord) {
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(xCoord + 1,yCoord));
        cells.add(new Cell(xCoord - 1,yCoord));
        cells.add(new Cell(xCoord,yCoord + 1));
        cells.add(new Cell(xCoord,yCoord - 1));
        Iterator<Cell> c = cells.iterator();
        while (c.hasNext()) {
            if (!testMove(c.next(), false)) {
                c.remove();
            }
        }
        return cells.size()==0 ? null : cells.get(ThreadLocalRandom.current().nextInt(0, cells.size()));
    }

    protected boolean testMove(Cell move, boolean checkLocks) {
        boolean result = true;
        int testX = move.getxCoord();
        int testY = move.getyCoord();
        if(testX <0
                || testX>=boardWithBlocks.length
                || testY <0
                || testY>=boardWithBlocks[0].length
                || boardWithBlocks[testX][testY] == 1) {
            result =  false;
        }
        if(checkLocks == true) {
            if(board[testX][testY].isLocked() == true) {
                result = false;
            }
        }
        //System.out.println(result);
        return result;
    }



    /**
     * Set stopped flag
     *
     * @param stopped flag
     */
    public synchronized void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    public Cell goUp(){
        Cell nextCell = new Cell(yCoord + 1, xCoord);
        return testMove(nextCell, false) ? nextCell : null;
    }

    public Cell goDown() {
        Cell nextCell = new Cell(yCoord - 1, xCoord);
        return testMove(nextCell, false) ? nextCell : null;
    }

    public Cell goLeft() {
        Cell nextCell = new Cell(yCoord , xCoord - 1);
        return testMove(nextCell, false) ? nextCell : null;
    }

    public Cell goRight() {
        Cell nextCell = new Cell(yCoord, xCoord + 1);
        return testMove(nextCell, false) ? nextCell : null;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (autoMoving == true) {
            board[xCoord][yCoord].lock();
            //System.out.println(Thread.currentThread().getName() + " acqired the cell X = " + yCoord + " Y = " + xCoord + " and trying to move to the next cell ");
            Cell nextCell;
            int newX  = xCoord;
            int newY = yCoord;
            //System.out.println(Thread.currentThread().getName() + " newX = " + newX + " newY = " + newY);
            try {
                while (!isStopped) {
                    nextCell = genNextCell(xCoord, yCoord);
                    try {
                        newX = nextCell.getxCoord();
                        newY = nextCell.getyCoord();
                    } catch (NullPointerException ep) {
                        ep.printStackTrace();
                        System.out.println(Thread.currentThread().getName() + " cell X = " + newY + " Y = " + newX + " ... waiting for 1s ");
                    }

                    //залочить текущую ячейку
                    //сгенерировать следующую ячейку
                    if (board[newX][newY].tryLock(500, TimeUnit.MILLISECONDS)) {
                            board[xCoord][yCoord].unlock();
                            //System.out.println(Thread.currentThread().getName() + " acqired the cell X = " + newY + " Y = " + newX + " ... waiting for 1s ");
                            xCoord = newX;
                            yCoord = newY;
                            //если да, то ждем 1000мс
                            //System.out.println(Thread.currentThread().getName() + "  sleeping");
                            try {
                                Thread.currentThread().sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    } else if (game.getHero().getxCoord() == newX && game.getHero().getyCoord() == newY){
                        //в этой ячейке герой!
                        System.out.println("intersection on cell X = " + yCoord + " Y = " + xCoord + " it's game over ='(");
                        game.stop();
                        //System.out.println(Thread.currentThread().getName() + " failed acqired the cell X = " + newY + " Y = " + newX + " ... regenerating new coords ");
                    }
                }
            } catch (InterruptedException e) {
                board[newX][newY].unlock();
                e.printStackTrace();
            }
        } else {
            board[xCoord][yCoord].lock();
            System.out.println(Thread.currentThread().getName() + " acqired the cell X = " + yCoord + " Y = " + xCoord + " and trying to move to the next cell ");
            //идем
            while (!isStopped) {
                Cell nextCell = goLeft();
                if (nextCell != null) {
                    if (!board[nextCell.getxCoord()][nextCell.getyCoord()].tryLock()) {
                        System.out.println("You are on the same cell with monster");
                        game.stop();
                    } else {
                        board[xCoord][yCoord].unlock();
                        xCoord = nextCell.getxCoord();
                        yCoord = nextCell.getyCoord();
                        System.out.println(Thread.currentThread().getName() + " acqired the cell X = " + yCoord + " Y = " + xCoord + " and trying to move to the next cell ");
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                nextCell = goRight();
                if (nextCell != null) {
                    if (!board[nextCell.getxCoord()][nextCell.getyCoord()].tryLock()) {
                        System.out.println("You are on the same cell with monster");
                        game.stop();
                    } else {
                        board[xCoord][yCoord].unlock();
                        xCoord = nextCell.getxCoord();
                        yCoord = nextCell.getyCoord();
                        System.out.println(Thread.currentThread().getName() + " acqired the cell X = " + yCoord + " Y = " + xCoord + " and trying to move to the next cell ");
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                nextCell = goDown();
                if (nextCell != null) {
                    if (!board[nextCell.getxCoord()][nextCell.getyCoord()].tryLock()) {
                        System.out.println("You are on the same cell with monster");
                        game.stop();
                    } else {
                        board[xCoord][yCoord].unlock();
                        xCoord = nextCell.getxCoord();
                        yCoord = nextCell.getyCoord();
                        System.out.println(Thread.currentThread().getName() + " acqired the cell X = " + yCoord + " Y = " + xCoord + " and trying to move to the next cell ");
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                nextCell = goUp();
                if (nextCell != null) {
                    if (!board[nextCell.getxCoord()][nextCell.getyCoord()].tryLock()) {
                        System.out.println("You are on the same cell with monster");
                        game.stop();
                    } else {
                        board[xCoord][yCoord].unlock();
                        xCoord = nextCell.getxCoord();
                        yCoord = nextCell.getyCoord();
                        System.out.println(Thread.currentThread().getName() + " acqired the cell X = " + yCoord + " Y = " + xCoord + " and trying to move to the next cell ");
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
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
