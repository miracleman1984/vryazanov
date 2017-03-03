package paint;


/**
 * Square class stores square properties and methods.
 *
 * @author vryazanov
 * @since 03.03.2017
 * @version 1
 */
public class Square implements Shape {
    /**
     * Pics square.
     *
     * @return string that describe a square
     */
    public String pic() {
        return "---" + System.lineSeparator()
                + "| |" + System.lineSeparator()
                + "---";
    }
}
