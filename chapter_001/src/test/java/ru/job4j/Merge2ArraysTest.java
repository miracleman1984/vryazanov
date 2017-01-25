package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Merge2Arrays test.
 *
 * @author vryazanov
 * @since 25.01.2016
 * @version 1
 */
 public class Merge2ArraysTest {
		/**
		 * Merge 2 arraye when max int in array 1.
		 */
		@Test
		public void whenMaxInArray1ThenReturnRight() {
			final Merge2Arrays mergeArray = new Merge2Arrays();
			final int[] givenArray1 = {1, 2, 3, 6};
			final int[] givenArray2 = {2, 3, 5};
			final int[] resultArray = {1, 2, 2, 3, 3, 5, 6};
			final int[] result = Merge2Arrays.merge(givenArray1, givenArray2);
			assertThat(result, is(resultArray));
		}
		/**
		 * Merge 2 arraye when max int in array 2.
		 */
		@Test
		public void whenMaxInArray2ThenReturnRight() {
			final Merge2Arrays mergeArray = new Merge2Arrays();
			final int[] givenArray1 = {2, 3, 5};
			final int[] givenArray2 = {1, 2, 3, 6};
			final int[] resultArray = {1, 2, 2, 3, 3, 5, 6};
			final int[] result = Merge2Arrays.merge(givenArray1, givenArray2);
			assertThat(result, is(resultArray));
		}
 }