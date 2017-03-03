package paint;


/**
 * Triangle class stores triangle properties and methods.
 *
 * @author vryazanov
 * @since 03.03.2017
 * @version 1
 */
public class Triangle implements Shape {
    /**
     * Pics triangle.
     *
     * @return string that describe a triangle
     */
    public String pic() {
        return "   ^   "
                + System.lineSeparator()
                + " /   \\"
                + System.lineSeparator()
                + "======";
    }
}
