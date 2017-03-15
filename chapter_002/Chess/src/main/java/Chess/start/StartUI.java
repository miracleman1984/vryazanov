package Chess.start;

import Chess.figures.Bishop;
import Chess.figures.Figure;

import static Chess.figures.Color.Black;

/**
 * Created by vr on 12.03.2017.
 */
public class StartUI {
    private Board board;

    public StartUI(Board board) {
        this.board = board;
    }

    public void init(){
        System.out.println("Let's start chess game");
        board.setFigures();

    }

    public static void main(String[] args) {
        Figure bishop1 = new Bishop(new Cell(2,3), Black)
        Figure bishop2 = new Bishop(new Cell(4,3), Black)
        new StartUI(new Board(new Figure[] {bishop1, bishop2})).init();
    }

}
