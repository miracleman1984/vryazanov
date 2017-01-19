package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.number.IsCloseTo.closeTo;
/**
 * Substring test.
 *
 * @author vryazanov
 * @since 19.01.2016
 * @version 1
 */
 public class SubstringTest {
	/**
	 * Is substring.
	 */
	@Test
	public void whenSubIsSubstringOfOriginThenReturnTrue() {
		final Substring subStringClass = new Substring();
		final String originString = "HiHiHi";
		final String subString = "iHi";
		final boolean result = subStringClass.contains(originString, subString);
		final boolean expectingResult = true;
		assertThat(result, is(expectingResult));
	}
	/**
	 * Empty substring.
	 */
	@Test
	public void whenSubIsEmptyThenReturnFalse() {
		final Substring subStringClass = new Substring();
		final String originString = "HiHiHi";
		final String subString = "";
		final boolean result = subStringClass.contains(originString, subString);
		final boolean expectingResult = false;
		assertThat(result, is(expectingResult));
	}
	/**
	 * Not substring.
	 */
	@Test
	public void whenSubIsNotSubstringOfOriginThenReturnFalse() {
		final Substring subStringClass = new Substring();
		final String originString = "HiaHiHia";
		final String subString = "aa";
		final boolean result = subStringClass.contains(originString, subString);
		final boolean expectingResult = false;
		assertThat(result, is(expectingResult));
	}
 }