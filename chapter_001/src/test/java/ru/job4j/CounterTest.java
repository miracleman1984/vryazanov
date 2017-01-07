package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Counter test.
 *
 * @author vryazanov
 * @since 06.01.2016
 * @version 1
 */
 public class CounterTest {
		/**
		 * Test sum when start is greater then second.
		 */
		@Test
		public void whenFromOneToTenThenTwentyFour() {
			final Counter counterClass = new Counter();
			final int result = counterClass.add(1, 10);
			assertThat(result, is(30));
		}
		/**
		 * Test sum when finish is greater then start.
		 */
		@Test
		public void whenFromTenToOneThenTwentyFour() {
			final Counter counterClass = new Counter();
			final int result = counterClass.add(10, 1);
			assertThat(result, is(30));
		}
 }