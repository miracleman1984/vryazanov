import java.util.HashMap;
import java.util.List;

/**
 * Class  UserList.
 * <p>
 * Converts users.
 *
 * @author vryazanov
 * @version 1.0
 * @since 22.03.2017
 */
public class UserConvert {
    /**
     * Converts List of users to HashMap.
     *
     * @param list of users to convert
     * @return Hashmap of users
     */
    public static HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
