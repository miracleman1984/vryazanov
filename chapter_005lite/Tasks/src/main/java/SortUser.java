import java.util.ArrayList;
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

    public static Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<User>();
        set.addAll(list);
        return set;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        User user1 = new User(1, "Vitaly", 30, "SPB");
        User user2 = new User(2, "Vital", 29, "SPB");
        User user3 = new User(3, "Vita", 28, "SPB");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        Set<User> set = SortUser.sort(list);
        System.out.println(set);
    }
}
