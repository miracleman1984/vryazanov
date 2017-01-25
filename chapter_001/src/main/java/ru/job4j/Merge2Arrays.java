package ru.job4j;

/**
 * Merge 2 two sorted by ascending arrays.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 25.01.2017
 * @version 1
 */
public class Merge2Arrays {
	/**
	 * Merge 2 two sorted by ascending arrays.
	 * @param array1 given array1
	 * @param array2 given array2
	 * @return merged array
	 */
	public static int[] merge(int[] array1, int[] array2) {
		 /**
		 * Store lenght of merged array.
		 */
		int resultLength = array1.length + array2.length;
		/**
		 * Store merged array.
		 */
        int[] result = new int[resultLength];
		/**
		 * Iterator for array1.
		 */
        int i = 0;
		/**
		 * Iterator for array2.
		 */
		int j = 0;
		/**
		 * Iterator for merged array.
		 */
		int k = 0;
        while (k < resultLength) {
            if ((i < array1.length && j < array2.length && array1[i] <= array2[j]) || (j >= array2.length)) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }
		return result;
	}
}


