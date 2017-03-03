package paint;


/**
 * Paint class that stores figure which it can operate and methods.
 *
 * @author vryazanov
 * @since 03.03.2017
 * @version 1
 */
public class Paint {
    /**
     * Store shape which it can operate.
     */
    private Shape shape;
    /**
     * Paint class constructor.
     *
     * @param shape on that it operates
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }
    /**
     * Set shape on that it operates.
     *
     * @param shape change paint shape to it
     */
    public void setStrategy(Shape shape) {
        this.shape = shape;
    }
    /**
     * Draw shape.
     */
    public void draw() {
        System.out.println(this.shape.pic());
    }
}
