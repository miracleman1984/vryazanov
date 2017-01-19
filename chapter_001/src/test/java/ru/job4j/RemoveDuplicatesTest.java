package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * RemoveDuplicates test.
 *
 * @author vryazanov
 * @since 19.01.2016
 * @version 1
 */
 public class RemoveDuplicatesTest {
	/**
	 * Given massive with len = 4 with 2 duplicates.
	 */
	@Test
	public void whenMassiveLenForAndTwoDuplThenReturnTwo() {
		final RemoveDuplicates duplArray = new RemoveDuplicates();
		final String[] givenArray = {"Привет", "Привет", "Мир", "Мир"};
		final String[] resultArray = {"Привет", "Мир"};
		final String[] result = duplArray.remove(givenArray);
		assertThat(result, is(resultArray));
	}
	/**
	 * Given massive is empty.
	 */
	@Test
	public void whenMassiveLenZeroThenReturnZero() {
		final RemoveDuplicates duplArray = new RemoveDuplicates();
		final String[] givenArray = {};
		final String[] resultArray = {};
		final String[] result = duplArray.remove(givenArray);
		assertThat(result, is(resultArray));
	}
 }