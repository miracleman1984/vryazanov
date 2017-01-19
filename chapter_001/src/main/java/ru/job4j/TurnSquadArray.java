package ru.job4j;
/**
 * TurnSquadArray class reverse massive.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 18.01.2017
 * @version 1
 */
public class TurnSquadArray {
	/**
	 * Returns reversed massive.
	 * @param numbers given massive
	 * @return reversed massive
	 */
	public int[][] turn(int[][] numbers) {
		 /**
		 * Store lower bound of current square.
		 */
        int low = 0;
		/**
		 * Store upper bound of current square.
		 */
        int hi = numbers.length - 1;
        while (low < (numbers.length - 1) / 2) {
            for (int j = 0; j < hi - low; j++) {
                int temp = numbers[low][low + j];
                numbers[low][low + j] = numbers[hi - j] [low];
                numbers[hi - j] [low] = numbers[hi][hi  - j];
                numbers[hi][hi  - j] = numbers[low + j][hi];
                numbers[low + j][hi] = temp;
            }
            hi--;
            low++;
        }
		return numbers;
	}
}