package ru.job4j.bomberman;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
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
    final private byte[][] boardWithBlocks;
    /**
     * Game units.
     */
    final private ArrayList<Unit> monsters = new ArrayList<Unit>();
    final private Unit hero;
    final private ArrayList<Block> blocks = new ArrayList<Block>();

    /**
     * Game constructor
     *
     * @param xSize board size
     * @param ySize board size
     * @param difficullty a number from 1 to 10
     */
//    1. Есть игровое поле - двухмерный массив. Есть герои - Бомбермен и чудовища.
//2. Приложение не должно блокировать все игровое поле.
//3. В поле должны существовать блоки. поля куда нельзя ходить.
//            4. Бомбермен должен управляться через пользователя. (Пользовательский ввод реализовывать не надо) только апи, для движения.
//5. Чудовища должны двигаться автоматически.
//            6. Предусмотреть, что если чудовище не может двинуться на клетку. например, там стоит другое чудовище, проверять в течении .5 секунд и двигаться в другую строну.
//            7. Сложность поля и количество чудовищ должно варьироваться.
    public Game(int xSize, int ySize, int difficullty) {
        this.board = new ReentrantLock[xSize][ySize];
        this.boardWithBlocks = new byte[xSize][ySize];
        for (int a = 0; a < xSize; a++) {
            for (int b = 0; b < ySize; b++) {
                this.board[a][b] = new ReentrantLock();
                this.boardWithBlocks[a][b] = 0;
            }
        }
        //todo: реализовать сложность: чем больше число , тем большее количество случайно расположенных монстров и блоков на поле
        //Общее количество клеток на поле за минусом героя:
        int freeCells = xSize*ySize - 1;
        int monstersNumber = (int) (freeCells * difficullty / 50);
        if (monstersNumber ==0) {
            monstersNumber = 1;
        }
        int blocksNumber = (int) (freeCells * difficullty / 30);

        System.out.println("Number of monsters = " + monstersNumber);
        System.out.println("Number of blocks = " + blocksNumber);
        Cell heroCell = genBoardCell();
        hero = new Hero("H", heroCell.getxCoord(), heroCell.getyCoord(), this);
        for (int i = 0; i < blocksNumber ; i++) {
            setBlock();
        }
        for (int i = 0; i < monstersNumber; i++) {
            setMonster();
        }

    }

    /**
     * Main test method.
     *
     * @param args some args
     * @throws InterruptedException exeption on sleep
     */
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(4, 4,10);
        game.start();
        System.out.println("The game is ending...");
        game.stop();

    }

    /**
     * Stop the game
     */
    public void stop() {
        hero.setStopped(true);
        for (Unit unit : monsters) {
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
    private void setMonster(String name, int xCoord, int yCoord) throws InterruptedException {
        for (Unit unit : monsters) {
            if (unit.getxCoord() == xCoord && unit.getyCoord() == yCoord)  {
                throw new OccupiedCellException(String.format("%s was trying to occupy the with  X = %d and Y = %s, but %s already was here", name, xCoord, yCoord, unit.getName()));
            }
        }
        if (boardWithBlocks[xCoord][yCoord] == 1) {
            throw new OccupiedCellException(String.format("%s was trying to occupy the with  X = %d and Y = %s, but block already was here", name, xCoord, yCoord));
        }
        monsters.add(new Monster(name, xCoord, yCoord, this));
    }

    private void setMonster() {
        String name = String.valueOf(monsters.size()+1);
        Cell monsterCell = genBoardCell();
        monsters.add(new Monster(name, monsterCell.getxCoord(), monsterCell.getyCoord(), this));
    }

    private void setHero() {

    }


    private void setBlock(int xCoord, int yCoord) {
            boardWithBlocks[xCoord][yCoord] = 1;
            System.out.println("Block has established on the cell X = " + xCoord + " Y = " + yCoord);
    }

    private void setBlock() {
        String name = "Monster " + ThreadLocalRandom.current().nextInt(0, 500);
        Cell blockCell = genBoardCell();
        boardWithBlocks[blockCell.getxCoord()][blockCell.getyCoord()] = 1;
    }


    /**
     * Start the game
     */
    private void start() throws InterruptedException {
        hero.start();
        for (Unit unit : monsters) {
            unit.start();
        }
        for (int i = 0; i < 20; i++) {
            printBoard();
            Thread.currentThread().sleep(1000);
        }
    }

    private void printBoard() {
        System.out.println();
        for (int a = 0; a < boardWithBlocks.length; a++) {
            for (int b = 0; b < boardWithBlocks[0].length; b++) {
                if (this.board[a][b].isLocked() == true) {
                    for (Unit unit : monsters) {
                        if (unit.xCoord == a && unit.getyCoord() ==b ) {
                            System.out.print(" " + unit.getName() + " ");
                            break;
                        }
                        if (hero.getxCoord() == a && hero.getyCoord() == b) {
                            System.out.print(" " + unit.getName() + " ");
                        }
                    }

                } else if (this.boardWithBlocks[a][b] == 1) {
                    System.out.print(" x ");
                } else {
                    System.out.print(" o ");
                }
            }
            System.out.println();
        }
    }

    private Cell genBoardCell() {
        List<Cell> cells = new ArrayList<Cell>();
        for (int a = 0; a < boardWithBlocks.length; a++) {
            for (int b = 0; b < boardWithBlocks[0].length; b++) {
                if (this.boardWithBlocks[a][b] == 0 && this.board[a][b].isLocked() == false) {
                    cells.add(new Cell(a,b));
                }
            }
        }
        return cells.size()==0 ? null : cells.get(ThreadLocalRandom.current().nextInt(0, cells.size()));
    }

    public ReentrantLock[][] getBoard() {
        return board;
    }

    public byte[][] getBoardWithBlocks() {
        return boardWithBlocks;
    }

    public Unit getHero() {
        return hero;
    }
}
