package chess.figures;

import chess.start.Cell;
import chess.chessExceptions.ImpossibleMoveException;

import java.util.ArrayList;

/**
 * Figure class that stores common properties and methods for all figures.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 20.03.2017
 */
public abstract class Figure {
    /**
     * Store current position of the figure.
     */
    private final Cell position;
    /**
     * Figure class constructor.
     *
     * @param position  where this figure is situated
     */
    public Figure(Cell position) {
        this.position = position;
    }
    /**
     * Return position of the figure.
     *
     * @return position of the figure
     */
    public Cell getPosition() {
        return position;
    }
    /**
     * Find the way to the cell.
     *
     * @param dist cell to
     * @return cells that has to pass throught
     * @throws ImpossibleMoveException if way to the cell is impossible for the figure
     */
    public abstract ArrayList<Cell> way(Cell dist) throws ImpossibleMoveException;
    /**
     * Clone this figure to the destination.
     *
     * @param dist cell to
     * @return clonned figure in the destination
     */
    public abstract Figure clone(Cell dist);
}
