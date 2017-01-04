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
 public class TriangleTest {
		/**
		 * Create unexisted triangle.
		 */
		@Test
		public void whenTriangleIsInpossibleThenShouldReturnMinusOne() {
			final Point pointA = new Point(0d, 0d);
		    final Point pointB = new Point(0d, 1d);
			final Point pointC = new Point(0d, 2d);
			final Triangle triangle = new Triangle(pointA, pointB, pointC);
			final double result = triangle.area();
			assertThat(result, is(-1d));
		}
		/**
		 * Create existed triangle and find its area.
		 */
		@Test
		public void whenTriangleIsPossibleThenShouldReturnItsArea() {
			final Point pointA = new Point(0d, 0d);
		    final Point pointB = new Point(3d, 0d);
			final Point pointC = new Point(0d, 4d);
			final Triangle triangle = new Triangle(pointA, pointB, pointC);
			final double result = triangle.area();
			assertThat(result, is(6d));
		}
 }