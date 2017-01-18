package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Turn test.
 *
 * @author vryazanov
 * @since 18.01.2016
 * @version 1
 */
 public class TurnTest {
		/**
		 * Create massive with len = 2.
		 */
		@Test
		public void whenMassiveLenTwoThenReturnSwitched() {
			final Turn turnArray = new Turn();
			final int[] givenArray = {1, 2, 3};
			final int[] resultArray = {3, 2, 1};
			final int[] result = turnArray.turn(givenArray);
			assertThat(result, is(resultArray));
		}
 }