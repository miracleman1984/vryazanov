package Chess.start;

/**
 * Created by vr on 12.03.2017.
 */
public class Cell {
    int x;
    int y;
    private final static String[] xSign = {
            "A","B","C","D","E","F","G","H"
    }
    private static int[] ySign = {
            1,2,3,4,5,6,7,8
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
