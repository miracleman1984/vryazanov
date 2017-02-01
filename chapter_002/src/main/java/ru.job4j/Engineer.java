package ru.job4j;

/**
 * Created by vr on 31.01.2017.
 */
public class Engineer extends Profession{

    public Engineer(People man, int[] specializationID,int level) {
        super(man, specializationID, level);
    }

    public void serve(Thing someThing){
        System.out.println("Engeneer is serving this thing");
    }
}
