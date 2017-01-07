package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Factorial test.
 *
 * @author vryazanov
 * @since 06.01.2016
 * @version 1
 */
 public class FactorialTest {
		/**
		 * Test factorial when argument is zero.
		 */
		@Test
		public void whenZeroThenOne() {
			final Factorial factorialClass = new Factorial();
			final int result = factorialClass.fact(0);
			assertThat(result, is(1));
		}
		/**
		 * Test factorial when argument is 5.
		 */
		@Test
		public void when5Then120() {
			final Factorial factorialClass = new Factorial();
			final int result = factorialClass.fact(5);
			assertThat(result, is(120));
		}
		/**
		 * Test factorial when argument is negative.
		 */
		@Test
		public void whenNegativeThenMinusOne() {
			final Factorial factorialClass = new Factorial();
			final int result = factorialClass.fact(-5);
			assertThat(result, is(-1));
		}
 }