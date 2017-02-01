package ru.job4j;

/**
 * Created by vr on 31.01.2017.
 */
public class Doctor extends Profession  {

    public Doctor(People man, int[] specializationID,int level) {
        super(man, specializationID, level);
    }

    public void cure(People man){
        System.out.println("Doctor is curing this man");
    }
}
