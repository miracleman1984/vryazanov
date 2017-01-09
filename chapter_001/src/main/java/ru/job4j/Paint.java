package ru.job4j;

/**
 * Paint class returns string with pyramid of ^ by given number and return error if number <=0.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 07.01.2017
 * @version 1
 */
public class Paint {
	/**
	 * Returns string with pyramid of ^ by given number and return error if number <=0..
	 * @param number Number
	 * @return string with pyramid of ^ by given number and return error if number <=0
	 */
	public String piramid(int number) {
		 /**
		 * Store resulting string.
		 */
		StringBuffer result = new StringBuffer();
		 /**
		 * Store width of pyramid.
		 */
		int width = 2 * number + 1;
		/**
		 * Store filling dash with symbol.
		 */
		String symbol = " ^";
		if (number <= 0) {
			result.append("Argument must be positive!");
		} else {
			for (int i = 1; i <= number; i++) {
				for (int k = 1; k <= width; k++) {
					if (k <= number - i || k >= number + i) {
						result.append(" ");
					} else {
						result.append(" ^");
						k++;
					}
				}
				result.append("/n/r");
			}
		}
		return result.toString();
	}
}