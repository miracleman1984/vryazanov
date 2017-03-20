package chess.figures;

import chess.chessExceptions.ImpossibleMoveException;
import chess.start.Cell;

import java.util.ArrayList;

/**
 * Bishop class that stores unique properties and methods for bishops.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 20.03.2017
 */
public class Bishop extends Figure {

    /**
     * Bishop class constructor.
     *
     * @param position  where this figure is situated
     */
    public Bishop(Cell position) {
        super(position);
    }
    @Override
    public ArrayList<Cell> way(Cell dist) throws ImpossibleMoveException {
        ArrayList<Cell> result = new ArrayList<Cell>();
        int figureX = this.getPosition().getX();
        int figureY = this.getPosition().getY();
        int plannedX = dist.getX();
        int plannedY = dist.getY();

        if (Math.abs(figureX - plannedX) != Math.abs(figureY - plannedY)) {
            throw new ImpossibleMoveException("Illegal move");
        }
        if ((figureX == plannedX) && (figureY == plannedY)) {
            throw new ImpossibleMoveException("The same position");
        }
        int incrX = (figureX - plannedX > 0) ? -1 : 1;
        int incrY = (figureY - plannedY > 0) ? -1 : 1;

        int currentX = figureX;
        int currentY = figureY;
        while (currentX != plannedX && currentY != plannedY) {
            currentX += incrX;
            currentY += incrY;
            result.add(new Cell(currentX, currentY));
        }
        return result;
    }
    @Override
    public Figure clone(Cell dist) {
        return new Bishop(dist);
    }
}
