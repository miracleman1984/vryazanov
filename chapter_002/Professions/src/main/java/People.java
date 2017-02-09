package ru.job4j;

/**
 * Created by vr on 03.02.2017.
 */
public class People {
    /**
     * Store name of the man.
     */
    private String name;
    /**
     * Store age of the man.
     */
    private int age;
    /**
     * Store sex (gender) of the man.
     */
    private boolean sex;
    /**
     * Store education document.
     */
    private Diploma diplom;
    /**
     * Store professions of the man.
     */
    private int[] professions;
    /**
     * People class constructor.
     * @param name education level
     * @param age id of colledge.
     * @param sex document number
     * @param diplom Cid of profenssion in diploma
     * @param professions Cid of profenssion in diploma
     */
    public People(String name, int age, boolean sex, Diploma diplom, int[] professions) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.diplom = diplom;
        this.professions = professions;
    }
    /**
     * Return name of the man.
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Set the name of the man.
     * @param name name of the man
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Return age of the man.
     * @return age
     */
    public int getAge() {
        return age;
    }
    /**
     * Set the age of the man.
     * @param age age of the man
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Return sex (gender) of the man.
     * @return sex. If true then male if false then woman.
     */
    public boolean isSex() {
        return sex;
    }
    /**
     * Set sex (gender) of the man.
     * @param sex If true then male if false then woman.
     */
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    /**
     * Return diplom of the man.
     * @return diplom
     */
    public Diploma getDiplom() {
        return diplom;
    }
    /**
     * Set diplom of the man.
     * @param diplom diplom of the man
     */
    public void setDiplom(Diploma diplom) {
        this.diplom = diplom;
    }
    /**
     * Return all professions of the man.
     * @return professions
     */
    public int[] getProfessions() {
        return professions;
    }
    /**
     * Set professions of the man.
     * @param professions professions of the man.
     */
    public void setProfessions(int[] professions) {
        this.professions = professions;
    }
}
