package Professions;

/**
 * Doctor class that stores unique properties and methods for doctors.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 06.02.2017
 * @version 1
 */
public class Doctor extends Profession  {
    /**
     * Doctor class constructor.
     * @param man man that haas profession - doctor
     * @param specializationID id doctor speciality.
     * @param level profficiency level 0-5
     */
    public Doctor(People man, int[] specializationID, int level) {
        super(man, specializationID, level);
    }

    /**
     * Cures another man.
     * @param man that cured
     * @return string about curing
     */
    public String cure(People man) {
        return "Doctor is curing this man";
    }
}
