package chess.start;

import chess.chessExceptions.FigureNotFoundException;
import chess.chessExceptions.ImpossibleMoveException;
import chess.chessExceptions.OccupiedWayException;
import chess.figures.Figure;

import java.util.ArrayList;

/**
 * Created by vr on 12.03.2017.
 */
public class Board {
    /**
     * Store figures on the board.
     */
    private Figure[] figures;
    /**
     * Store size of the board.
     */
    private final int size = 8;
    /**
     * Board class constructor.
     *
     * @param figures  set figures on the board
     */
    public Board(Figure[] figures) {
        this.figures = figures;
    }
    /**
     * Move figure from source to destination point..
     *
     * @param source cell from
     * @param dist cell to
     * @return true operation has been proceed successfully and false otherwise
     * @throws ImpossibleMoveException if way to the cell is impossible for the figure
     * @throws OccupiedWayException if on the way to the cell exists other figures.
     * @throws FigureNotFoundException if Figure not found in the source
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        //  Метод должен должен проверить
        //   - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
        //   - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
        //   - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
        //   - Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dist)
        boolean result = false;

        if (!isCellInBoard(source) || !isCellInBoard(dist)) {
            throw new ImpossibleMoveException("The cell out of board");
        }
        Figure sourceFigure = null;
        if (!isFigureInCell(source)) {
            throw new FigureNotFoundException("No figure in source cell");
        } else {
            for (Figure figure : this.figures) {
                if (figure.getPosition() == source) {
                    sourceFigure = figure;
                    break;
                }
            }
        }
        ArrayList<Cell> cells = sourceFigure.way(dist);
        for (Cell cell : cells) {
            if (isFigureInCell(cell)) {
                throw new OccupiedWayException("Way is occupied by another figure (s) ");
            }
        }
        result = true;
        sourceFigure.clone(dist);
        return result;
    }
    /**
     * Check is cell on the board.
     *
     * @param cell to be checked
     * @return true if the cell on the board and false otherwise
     */
    private boolean isCellInBoard(Cell cell) {
        boolean result = true;
        if (cell.getX() < 1 || cell.getY() < 1 || cell.getX() > this.size || cell.getY() > this.size) {
            result = false;
        }
        return result;
    }
    /**
     * Check is figure in the cell.
     *
     * @param cell to be checked
     * @return true if there is a figure in the cell and false otherwise
     */
    private boolean isFigureInCell(Cell cell) {
        boolean result = false;
        for (Figure figure : this.figures) {
            if (figure.getPosition().equals(cell)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
