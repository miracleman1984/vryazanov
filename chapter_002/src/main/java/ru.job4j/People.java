package ru.job4j;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * Created by vr on 31.01.2017.
 */
public class People {
    String name;
    int age;
    boolean sex;
    Diploma diplom;
    int[] professions;

    public People(String name, int age, boolean sex, Diploma diplom, int[] professions) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.diplom = diplom;
        this.professions = professions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Diploma getDiplom() {
        return diplom;
    }

    public void setDiplom(Diploma diplom) {
        this.diplom = diplom;
    }

    public int[] getProfessions() {
        return professions;
    }

    public void setProfessions(int[] professions) {
        this.professions = professions;
    }
}
