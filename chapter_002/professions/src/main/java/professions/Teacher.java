package professions;

/**
 * Teacher class that stores unique properties and methods for Teacher.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 06.02.2017
 * @version 1
 */
public class Teacher extends Profession {
    /**
     * Teacher class constructor.
     * @param man man that has profession - Teacher
     * @param specializationID id speciality.
     * @param level profficiency level 0-5
     */
    public Teacher(People man, int[] specializationID, int level) {
        super(man, specializationID, level);
    }

    /**
     * Learn someone.
     * @param man that learned
     * @return string about learning
     */
    public String learn(People man) {
        return "Teacher is teaching this man";
    }
}
