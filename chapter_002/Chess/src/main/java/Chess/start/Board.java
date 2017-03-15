package Chess.start;

import Chess.chessExceptions.FigureNotFoundException;
import Chess.chessExceptions.ImpossibleMoveException;
import Chess.chessExceptions.OccupiedWayException;
import Chess.figures.Figure;

import java.util.Date;

/**
 * Created by vr on 12.03.2017.
 */
public class Board {
    Figure[] figures;

    public Board(Figure[] figures) {
        this.figures = figures;
    }

    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        //  Метод должен должен проверить
        //   - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
        //   - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
        //   - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
        //   - Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dist)
        boolean result = false;
        Figure figure = null;
        try {

        } catch (FigureNotFoundException fnf) {
            System.out.println("fnf");
        }
        try {

        } catch (ImpossibleMoveException im) {
            System.out.println("im");
        }
        try {

        } catch (OccupiedWayException ow) {
            System.out.println("ow");
        }

        figure.clone(Cell dist);
    }

    public void setFigures(){

    };
}
