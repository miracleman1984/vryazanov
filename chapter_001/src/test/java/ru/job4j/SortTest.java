package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Sort test.
 *
 * @author vryazanov
 * @since 18.01.2016
 * @version 1
 */
 public class SortTest {
		/**
		 * Create massive with len = 5.
		 */
		@Test
		public void whenMassiveIsUnsortedThenReturnSorted() {
			final Sort sortArray = new Sort();
			final int[] givenArray = {5, 3, 4, 2, 1};
			final int[] resultArray = {1, 2, 3, 4, 5};
			final int[] result = sortArray.sort(givenArray);
			assertThat(result, is(resultArray));
		}
 }