/**
 * Class  User.
 * <p>
 * Base class for user properties and methods
 *
 * @author vryazanov
 * @version 1.0
 * @since 22.03.2017
 */
public class User {
    /**
     * Store unique id of user.
     */
    private int id;
    /**
     * Store name of user.
     */
    private String name;
    /**
     * Store user city.
     */
    private String city;
    /**
     * User class constructor.
     *
     * @param id  unique id of the user
     * @param name of the user
     * @param city of the user
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    /**
     * Return id of the user.
     *
     * @return id of the user
     */

    public int getId() {
        return id;
    }
    /**
     * Return name of the user.
     *
     * @return name of the user
     */
    public String getName() {
        return name;
    }
    /**
     * Return city of the user.
     *
     * @return city of the user
     */
    public String getCity() {
        return city;
    }
}
