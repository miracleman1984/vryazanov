package professions;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Engineer test.
 *
 * @author vryazanov
 * @since 25.01.2016
 * @version 1
 */
public class EngineerTest {
    /**
     * Engineer is serving something.
     */
    @Test
    public void whenEngineerServeSomethingThenMustBeMessage() {
        Thing computer = new Thing("Computer", 0, true);
        Diploma teacherDiplom = new Diploma(5, 10, 5555, 10);
        People engineer  = new People("Anrey", 52, true, teacherDiplom, new int[]{1});
        Profession newEngineer = new Engineer(engineer, new int[]{12}, 0);
        String result = ((Engineer) newEngineer).serve(computer);
        String haveToBe = "Engeneer is serving this thing";
        assertThat(result, is(haveToBe));
    }
}