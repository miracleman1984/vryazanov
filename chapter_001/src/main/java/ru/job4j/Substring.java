package ru.job4j;
/**
 * Substring test for testing is sub is substing of origin.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 19.01.2017
 * @version 1
 */
public class Substring {
	/**
	 * Returns true if sub is is substing of origin and false othewise.
	 * @param origin given sting
	 * @param sub test string
	 * @return isSubstring
	 */
	public boolean contains(String origin, String sub) {
		/**
		 * Store char massive of given string .
		 */
		char[] originString = origin.toCharArray();
        /**
		 * Store char massive of given string .
		 */
		char[] subString = sub.toCharArray();
        /**
		 * Store current counter of equals sybbols.
		 */
        int count = 0;
		/**
		 * Store length of testing substring.
		 */
        int lenOrigin = originString.length;
		/**
		 * Store length of origin string.
		 */
        int lenSubstring = subString.length;
		/**
		 * Store result.
		 */
		boolean result = false;
		if (lenSubstring == 0) {
			return result;
		}
        for (int i = 0; i < lenOrigin; i++) {
            if (originString[i] == subString[count]) {
                count++;
            } else {
				count = 0;
			}
            if (count == lenSubstring) {
                result = true;
                break;
            }
        }
		return result;
	}
}