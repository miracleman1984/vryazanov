package chess.start;

/**
 * Cell class that stores coordinates X and Y for the cell.
 *
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @version 1
 * @since 20.03.2017
 */
public class Cell {
    /**
     * Store x coordinate.
     */
    private int x;
    /**
     * Store y coordinate.
     */
    private int y;

    /**
     * Cell class constructor.
     *
     * @param x set x coordinate
     * @param y set y coordinate
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Return x coordinate.
     *
     * @return x coordinate
     */
    public int getX() {
        return x;
    }
    /**
     * Return y coordinate.
     *
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Cell{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        if (x != cell.x) {
            return false;
        }
        return y == cell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
