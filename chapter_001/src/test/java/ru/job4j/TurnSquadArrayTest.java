package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * TurnSquadArray test.
 *
 * @author vryazanov
 * @since 18.01.2016
 * @version 1
 */
 public class TurnSquadArrayTest {
		/**
		 * Create massive with len = 1.
		 */
		@Test
		public void whenMassiveLenOneThenReturnItself() {
			final TurnSquadArray turnArray = new TurnSquadArray();
			final int[][] givenArray = {{1}};
			final int[][] resultArray = {{1}};
			final int[][] result = turnArray.turn(givenArray);
			assertThat(result, is(resultArray));
		}
		/**
		 * Create massive with len = 5.
		 */
		@Test
		public void whenMassiveLenFiveThenReturnTurnedMassive() {
			final TurnSquadArray turnArray = new TurnSquadArray();
			final int[][] givenArray = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
			final int[][] resultArray = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
			final int[][] result = turnArray.turn(givenArray);
			assertThat(result, is(resultArray));
		}
 }