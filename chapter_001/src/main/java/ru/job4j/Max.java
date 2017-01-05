package ru.job4j;

/**
 * Max class calculate maxinum of two numbers.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 05.01.2017
 * @version 1
 */
public class Max {
	/**
	 * Calculate maxinum of two numbers..
	 * @param first First number
	 * @param second First number
	 * @return maximum
	 */
	public int max(int first, int second) {
		return first >= second ? first : second;
	}
}