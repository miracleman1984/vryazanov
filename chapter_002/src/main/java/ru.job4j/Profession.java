package ru.job4j;

/**
 * Created by vr on 31.01.2017.
 */
public abstract class Profession {
    People man;
    public int[] specializationID;
    int level;


    public Profession(People man, int[] specializationID, int level) {
        this.man = man;
        this.specializationID = specializationID;
        this.level = level;
    }

    public People getMan() {
        return man;
    }

    public void setMan(People man) {
        this.man = man;
    }

    public int[] getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(int[] specializationID) {
        this.specializationID = specializationID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void communicate(People man) {
        System.out.println("They communicating");
    }
}
