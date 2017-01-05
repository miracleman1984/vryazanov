package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Max test.
 *
 * @author vryazanov
 * @since 05.01.2016
 * @version 1
 */
 public class MaxTest {
		/**
		 * Test max when second is maximum.
		 */
		@Test
		public void whenFindMaxOfTwoAndThreeThenShouldReurnThree() {
			final Max maxClass = new Max();
			final int result = maxClass.max(2, 3);
			assertThat(result, is(3));
		}
		/**
		 * Test max when first equal second and third is greater.
		 */
		@Test
		public void whenFindMaxOfThreeThreeFiveThenShouldReurnFive() {
			final Max maxClass = new Max();
			final int result = maxClass.max(3, 3, 5);
			assertThat(result, is(5));
		}
 }