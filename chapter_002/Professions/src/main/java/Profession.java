package ru.job4j;

/**
 * Profession abstract class that stores shared properties and methods for all professions.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 06.02.2017
 * @version 1
 */
public abstract class Profession {
    /**
     * Store definite man.
     */
    private People man;
    /**
     * Store id specialisation.
     */
    private  int[] specializationID;
    /**
     * Store profficiency level 0-5n.
     */
    private int level;

    /**
     * Engineer class constructor.
     * @param man man that has profession
     * @param specializationID id speciality.
     * @param level profficiency level 0-5
     */
    public Profession(People man, int[] specializationID, int level) {
        this.man = man;
        this.specializationID = specializationID;
        this.level = level;
    }
    /**
     * Return man.
     * @return man
     */
    public People getMan() {
        return man;
    }
    /**
     * Set the man that has this profession.
     * @param man man whose setted for this place
     */
    public void setMan(People man) {
        this.man = man;
    }
    /**
     * Return SpecializationID of this professional.
     * @return specializationID id speciality
     */
    public int[] getSpecializationID() {
        return specializationID;
    }
    /**
     * Set SpecializationID of this professional.
     * @param specializationID id speciality
     */
    public void setSpecializationID(int[] specializationID) {
        this.specializationID = specializationID;
    }
    /**
     * Return level profficiency 0-5.
     * @return level profficiency
     */
    public int getLevel() {
        return level;
    }
    /**
     * Return level profficiency 0-5.
     * @param  level profficiency
     */
    public void setLevel(int level) {
        this.level = level;
    }
    /**
     * Communicating this another man.
     * @param man another man
     */
    public void communicate(People man) {
        System.out.println("They communicating");
    }
}
