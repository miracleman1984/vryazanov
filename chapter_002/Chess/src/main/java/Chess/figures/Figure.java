package Chess.figures;

import Chess.start.Cell;
import Chess.chessExceptions.ImpossibleMoveException;

/**
 * Created by vr on 12.03.2017.
 */
public abstract class Figure {
    final Cell position;
    final Color color;

    public Figure(Cell position,Color color) {
        this.position = position;
        this.color = color;
    }

    public Cell[] way(Cell dist) throws ImpossibleMoveException {

    }

    public clone(Cell dist) {

    }
}
