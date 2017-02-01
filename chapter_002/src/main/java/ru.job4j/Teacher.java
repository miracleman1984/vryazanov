package ru.job4j;

/**
 * Created by vr on 31.01.2017.
 */
public class Teacher extends Profession {

    public Teacher(People man, int[] specializationID,int level) {
        super(man, specializationID, level);
    }

    public void learn(People man){
        System.out.println("Teacher is teaching this man");
    }
}
