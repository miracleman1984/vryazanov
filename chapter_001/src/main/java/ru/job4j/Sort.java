package ru.job4j;

/**
 * Sort class sorting out the massive.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.01.2017
 * @version 1
 */
public class Sort {
	/**
	 * Returns sorted massive .
	 * @param values given massive
	 * @return sorted massive
	 */
	public int[] sort(int[] values) {
		 /**
		 * Store lenght of given massive.
		 */
		int len = values.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (values[i] > values[j]) {
					int temp = values[i];
					values[i] = values[j];
					values[j] = temp;
				}
			}
		}
		return values;
	}
}