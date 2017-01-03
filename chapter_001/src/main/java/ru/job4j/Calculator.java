package ru.job4j;

/**
 * Calculate class.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 03.01.2017
 * @version 1
 */
public class Calculator {
	/**
	 * Store result.
	 */
	private double result;
	/**
	 * Add numbers.
	 * @param first First
	 * @param second Second
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	 * Substruct numbers.
	 * @param first First
	 * @param second Second
	 */
	public void substruct(double first, double second) {
		this.result = first - second;
	}
	/**
	 * Divide numbers.
	 * @param first First
	 * @param second Second
	 */
	public void div(double first, double second) {
		this.result = first / second;
	}
	/**
	 * Multiply numbers.
	 * @param first First
	 * @param second Second
	 */
	public void multiply(double first, double second) {
		this.result = first * second;
	}
	/**
	 * Get result.
	 * @return Result.
	 */
	public double getResult() {
		return this.result;
	}
}