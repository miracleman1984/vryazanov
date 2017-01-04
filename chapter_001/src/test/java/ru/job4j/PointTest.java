package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Point test.
 *
 * @author vryazanov
 * @since 04.01.2016
 * @version 1
 */
 public class PointTest {
		/**
		 * Test distance.
		 */
		@Test
		public void whenFindDistanceThenShouldFindItRight() {
			final Point pointA = new Point(4d, 5d);
		    final Point pointB = new Point(1d, 1d);
			final double result = pointA.distanceTo(pointB);
			assertThat(result, is(5d));
		}
 }