package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Paint test.
 *
 * @author vryazanov
 * @since 07.01.2016
 * @version 1
 */
 public class PaintTest {
		/**
		 * Test paint when nothing to paint.
		 */
		@Test
		public void whenZeroThenErrorMessage() {
			final Paint paintClass = new Paint();
			final String result = paintClass.piramid(0);
			assertThat(result, is("Argument must be positive!"));
		}
		/**
		 * Test paint when height is correct.
		 */
		@Test
		public void whenThreeThenPyramidWithHeightThree() {
			final Paint paintClass = new Paint();
			final String result = paintClass.piramid(3);
			assertThat(result, is("   ^   /n/r  ^ ^  /n/r ^ ^ ^ /n/r"));
		}
 }