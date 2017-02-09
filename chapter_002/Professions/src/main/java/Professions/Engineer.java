package Professions;

/**
 * Engineer class that stores unique properties and methods for Engineers.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 06.02.2017
 * @version 1
 */
public class Engineer extends Profession {
    /**
     * Engineer class constructor.
     * @param man man that has profession - Engineer
     * @param specializationID id Engineer speciality.
     * @param level profficiency level 0-5
     */
    public Engineer(People man, int[] specializationID, int level) {
        super(man, specializationID, level);
    }

    /**
     * Serves something.
     * @param someThing that served
     * @return string about serving
     * */
    public String serve(Thing someThing) {
        return "Engeneer is serving this thing";
    }
}
