package ru.job4j;

/**
 * Factorial class calculate fatorial of given number.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 07.01.2017
 * @version 1
 */
public class Factorial {
	/**
	 * Calculate factorial of given number.
	 * @param number Number
	 * @return factorial of given number
	 */
	public int fact(int number) {
		 /**
		 * Store sum of numbers.
		 */
		int factorial = 1;
		if (number > 0) {
			for (int i = 1; i <= number; i++) {
				factorial *= i;
			}
		} else if (number < 0) {
			factorial = -1;
		} else {
			factorial = 1;
		}
		return factorial;
	}
}