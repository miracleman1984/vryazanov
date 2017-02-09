package professions;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Teacher test.
 *
 * @author vryazanov
 * @since 25.01.2016
 * @version 1
 */
public class TeacherTest {
    /**
     * Teacher is learning somebody.
     */
    @Test
    public void whenTeacherLearnSomebodyThenMustBeMessage() {
        Diploma teacherDiplom = new Diploma(5, 10, 5555, 10);
        People teacher  = new People("Viktor", 56, true, teacherDiplom, new int[]{2, 5});
        People doctor  = new People("Sergey", 23, true, teacherDiplom, new int[]{8, 20, 50});
        Profession newTeacher = new Teacher(teacher, new int[]{25, 72}, 1);
        String result = ((Teacher) newTeacher).learn(doctor);
        String haveToBe = "Teacher is teaching this man";
        assertThat(result, is(haveToBe));
    }
}