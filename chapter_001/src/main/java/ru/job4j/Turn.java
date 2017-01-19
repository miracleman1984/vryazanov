package ru.job4j;

/**
 * Turn class reverse massive.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.01.2017
 * @version 1
 */
public class Turn {
	/**
	 * Returns reversed massive.
	 * @param numbers given massive
	 * @return reversed massive
	 */
	public int[] turn(int[] numbers) {
		 /**
		 * Store lenght of given massive.
		 */
		int lenNumbers = numbers.length;
		for (int i = 0; i < lenNumbers / 2; i++) {
			int temp = numbers[i];
			numbers[i] = numbers[lenNumbers - i - 1];
			numbers[lenNumbers - i - 1] = temp;
		}
		return numbers;
	}
}


