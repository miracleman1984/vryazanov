package chess;

import chess.chessExceptions.FigureNotFoundException;
import chess.chessExceptions.ImpossibleMoveException;
import chess.chessExceptions.OccupiedWayException;
import chess.figures.Bishop;
import chess.figures.Figure;
import chess.start.Board;
import chess.start.Cell;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for class Board.
 *
 * @author vryazanov
 * @version 1.0
 * @since 20.03.2017
 */
public class BoardTest {
    /**
     * If no problems then should just return true.
     *
     * @throws ImpossibleMoveException if way to the cell is impossible for the figure
     * @throws OccupiedWayException if on the way to the cell exists other figures.
     * @throws FigureNotFoundException if Figure not found in the source
     */
    @Test
    public void whenNoProblemWithMoveThenShowCells() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Cell from = new Cell(1, 1);
        Cell to = new Cell(8, 8);
        Figure bishop1 = new Bishop(from);
        boolean result = new Board(new Figure[]{bishop1}).move(from, to);
        assertThat(result, is(true));
    }
    /**
     * If one of celss (to or from) is out of board.
     *
     * @throws ImpossibleMoveException if way to the cell is impossible for the figure
     * @throws OccupiedWayException if on the way to the cell exists other figures.
     * @throws FigureNotFoundException if Figure not found in the source
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenOneOfCellsIsOutOfTheBoardThenThrowImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Cell from = new Cell(1, 1);
        Cell to = new Cell(9, 9);
        Figure bishop1 = new Bishop(from);
        boolean result = new Board(new Figure[]{bishop1}).move(from, to);
    }
    /**
     * If the figure can't move to the destination point because it is not allowed for this type of figure.
     *
     * @throws ImpossibleMoveException if way to the cell is impossible for the figure
     * @throws OccupiedWayException if on the way to the cell exists other figures.
     * @throws FigureNotFoundException if Figure not found in the source
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenDestinationPointIsUnrichableByTheFigureThenThrowImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Cell from = new Cell(1, 1);
        Cell to = new Cell(1, 2);
        Figure bishop1 = new Bishop(from);
        boolean result = new Board(new Figure[]{bishop1}).move(from, to);
    }
    /**
     * If no figure in source point.
     *
     * @throws ImpossibleMoveException if way to the cell is impossible for the figure.
     * @throws OccupiedWayException if on the way to the cell exists other figures.
     * @throws FigureNotFoundException if Figure not found in the source
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenNoFigureInCellToMoveThenThrowFigureNotFoundException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Cell from = new Cell(1, 1);
        Cell bishopCell = new Cell(1, 2);
        Cell to = new Cell(1, 2);
        Figure bishop1 = new Bishop(bishopCell);
        boolean result = new Board(new Figure[]{bishop1}).move(from, to);
    }
    /**
     * If the way to the destination point is occupiesd by other figures.
     *
     * @throws ImpossibleMoveException if way to the cell is impossible for the figure
     * @throws OccupiedWayException if on the way to the cell exists other figures.
     * @throws FigureNotFoundException if Figure not found in the source
     */
    @Test(expected = OccupiedWayException.class)
    public void whenNoFigureInCellToMoveThenThrowOccupiedWayException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Cell from = new Cell(1, 1);
        Cell secondBishop = new Cell(3, 3);
        Cell to = new Cell(8, 8);
        Figure bishop1 = new Bishop(from);
        Figure bishop2 = new Bishop(secondBishop);
        boolean result = new Board(new Figure[]{bishop1, bishop2}).move(from, to);
    }
    /**
     * If source and destination point the same.
     *
     * @throws ImpossibleMoveException if way to the cell is impossible for the figure
     * @throws OccupiedWayException if on the way to the cell exists other figures.
     * @throws FigureNotFoundException if Figure not found in the source
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenFromAndToTheSameThenThrowImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Cell from = new Cell(1, 1);
        Cell to = new Cell(1, 1);
        Figure bishop1 = new Bishop(from);
        boolean result = new Board(new Figure[]{bishop1}).move(from, to);
    }
}
