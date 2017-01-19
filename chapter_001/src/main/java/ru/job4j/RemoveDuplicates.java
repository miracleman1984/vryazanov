package ru.job4j;
import java.util.Arrays;
/**
 * RemoveDuplicates remove duplicates string from given string massive.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 19.01.2017
 * @version 1
 */
public class RemoveDuplicates {
	/**
	 * Returns massive without duplicates.
	 * @param strings given massive
	 * @return reversed massive
	 */
	public String[] remove(String[] strings) {
		 /**
		 * Store resulting massive.
		 */
        String[] result = new String[strings.length];
		/**
		 * Count elements in new massive.
		 */
        int count = 0;
        for (String s : strings) {
            System.out.println(s);
            boolean hasDuplicate = false;
            for (int i = 0; i < count; i++) {
                if (s.equals(result[i])) {
                    hasDuplicate = true;
                }
            }
            if (!hasDuplicate) {
                result[count] = s;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
	}
}