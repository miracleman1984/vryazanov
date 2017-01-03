package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Calculator test.
 *
 * @author vryazanov
 * @since 03.01.2016
 * @version $Id$
 */

public class CalculatorTest {
		/**
		 * Test add.
		 */
		@Test
		public void whenAddThenShouldSummateIt() {
			final Calculator calc = new Calculator();
			calc.add(1, 1);
			final double result = calc.getResult();
			assertThat(result, is(2d));
		}
		/**
		 * Test substruct.
		 */
		 @Test
		public void whenSubstructThenShouldSubstructIt() {
			final Calculator calc = new Calculator();
			calc.substruct(1, 1);
			final double result = calc.getResult();
			assertThat(result, is(0d));
		}
		/**
		 * Test division.
		 */
		@Test
		public void whenDivThenShouldDivideIt() {
			final Calculator calc = new Calculator();
			calc.div(1, 1);
			final double result = calc.getResult();
			assertThat(result, is(1d));
		}
		/**
		 * Test multiply.
		 */
		 @Test
		public void whenMultipleThenShouldMultiplyIt() {
			final Calculator calc = new Calculator();
			calc.multiply(1, 1);
			final double result = calc.getResult();
			assertThat(result, is(1d));
		}
}
