package Professions;

/**
 * Diploma class that stores diploma details.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 06.02.2017
 * @version 1
 */
public class Diploma {
    /**
     * Store education level, for example school, institute.
     */
    private int educationLeveID;
    /**
     * Store id of colledge.
     */
    private int colledgeID;
    /**
     * Store document number.
     */
    private int number;
    /**
     * Store id of profenssion in diploma.
     */
    private int professionID;
    /**
     * Diploma class constructor.
     * @param educationLeveID education level
     * @param colledgeID id of colledge.
     * @param number document number
     * @param professionID Cid of profenssion in diploma
     */
    public Diploma(int educationLeveID, int colledgeID, int number, int professionID) {
        this.educationLeveID = educationLeveID;
        this.colledgeID = colledgeID;
        this.number = number;
        this.professionID = professionID;
    }
    /**
     * Return educationLeveID of diploma.
     * @return educationLeveID
     */
    public int getEducationLeveID() {
        return educationLeveID;
    }
    /**
     * Return colledgeID of diploma.
     * @return colledgeID
     */
    public int getColledgeID() {
        return colledgeID;
    }
    /**
     * Return number of diploma.
     * @return number
     */
    public int getNumber() {
        return number;
    }
    /**
     * Return professionID of diploma.
     * @return professionID
     */
    public int getProfessionID() {
        return professionID;
    }
}
