package professions;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Doctor test.
 *
 * @author vryazanov
 * @since 25.01.2016
 * @version 1
 */
public class DoctorTest {
    /**
     * Doctor is curing somebody.
     */
    @Test
    public void whenDoctorHealSomebodyThenMustBeMessage() {
        Diploma teacherDiplom = new Diploma(5, 10, 5555, 10);
        People teacher = new People("Viktor", 56, true, teacherDiplom, new int[]{2, 5});
        People doctor = new People("Sergey", 23, true, teacherDiplom, new int[]{8, 20, 50});
        Profession newDoctor = new Doctor(doctor, new int[]{37, 85}, 3);
        String result = ((Doctor) newDoctor).cure(teacher);
        String haveToBe = "Doctor is curing this man";
        assertThat(result, is(haveToBe));
    }
}