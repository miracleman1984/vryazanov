import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class  SortUser.
 * <p>
 * Methods for sorting users
 *
 * @author vryazanov
 * @version 1.0
 * @since 22.03.2017
 */
public class SortUser {
    /**
     * Converts sorts list of users by the comparator.
     *
     * @param list to convert
     * @return sorted set of users
     */
    public static Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<User>();
        set.addAll(list);
        return set;
    }
}
