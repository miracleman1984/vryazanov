import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class  ConvertList.
 *
 * Converts List to Array and Array to List.
 *
 * @author vryazanov
 * @version 1.0
 * @since 27.02.2017
 */
public class ConvertList {
    /**
     * Converts Array to List.
     * @param array to convert
     * @return List
     */
    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int[] i : array) {
            for (int j : i) {
                result.add(j);
            }
        }
        return result;
    }
    /**
     * Converts List to Array.
     * @param list to convert
     * @param rows amount os rows in converted array
     * @return array
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] result = new int[rows][rows];
        Iterator<Integer> iter = list.listIterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (iter.hasNext()) {
                    result[i][j] = iter.next();
                }
            }
        }
        return result;
    }
}
