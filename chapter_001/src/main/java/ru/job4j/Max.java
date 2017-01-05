package ru.job4j;

/**
 * Max class calculate maxinum of two numbers.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 05.01.2017
 * @version 1
 */
public class Max {
	/**
	 * Calculate maximum of two numbers..
	 * @param first First number
	 * @param second Second number
	 * @return maximum
	 */
	public int max(int first, int second) {
		return first >= second ? first : second;
	}
	/**
	 * Calculate maxinum of three numbers..
	 * @param first First number
	 * @param second Second number
	 * @param third Third number
	 * @return maximum
	 */
	public int max(int first, int second, int third) {
		return max(max(first, second), third);
	}
}