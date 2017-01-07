package ru.job4j;

/**
 * Max class calculate sum of even numbers in diapazon.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 06.01.2017
 * @version 1
 */
public class Counter {
	/**
	 * Calculate  sum of even numbers in diapazon.
	 * @param start One of diapazon bounds
	 * @param finish  Another diapazon bound
	 * @return sum of even nunbers in diapazon
	 */
	public int add(int start, int finish) {
		 /**
		 * Store sum of numbers.
		 */
		int sum = 0;
		if (start > finish) {
			int temp = start;
			start = finish;
			finish = temp;
		}
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}
}