package paint;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Paint class that stores figure which it can operate and methods.
 *
 * @author vryazanov
 * @since 03.03.2017
 * @version 1
 */
public class PaintTest {
    /**
     * Test drawing a triangle.
     */
    @Test
    public void whenStrategyTriangleThenShowIt() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint(new Triangle());
        paint.draw();
        assertThat(
                out.toString(),
                is(
                        String.format(
                            "   ^   "
                            + System.lineSeparator()
                            + " /   \\"
                            + System.lineSeparator()
                            + "======"
                            + System.lineSeparator()
                        )
                )
        );
    }
    /**
     * Test drawing a square.
     */
    @Test
    public void whenStrategySquareThenShowIt() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint(new Square());
        paint.draw();
        assertThat(
                out.toString(),
                is(
                        String.format(
                            "---" + System.lineSeparator()
                            + "| |" + System.lineSeparator()
                            + "---" + System.lineSeparator()
                        )
                )
        );
    }
    /**
     * Test drawing a triangle and then a square.
     */
    @Test
    public void whenChangingStrategyFromTriangleToSquareThenShowBoth() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint(new Triangle());
        paint.draw();
        paint.setStrategy(new Square());
        paint.draw();
        assertThat(
                out.toString(),
                is(
                        String.format(
                            "   ^   "
                            + System.lineSeparator()
                            + " /   \\"
                            + System.lineSeparator()
                            + "======"
                            + System.lineSeparator()
                            + "---"
                            + System.lineSeparator()
                            + "| |"
                            + System.lineSeparator()
                            + "---"
                            + System.lineSeparator()
                        )
                )
        );
    }

}
