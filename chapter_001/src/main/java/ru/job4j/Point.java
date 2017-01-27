package ru.job4j;

/**
 * Point class keeps point coords.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 03.01.2017
 * @version 1
 */
public class Point {
	/**
	 * Store coord x.
	 */
	private double x;
	/**
	 * Store coord y.
	 */
	private double y;
	/**
	 * Point class constructor.
	 * @param x Coord x
	 * @param y Coord y
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Calculate distance between two points.
	 * @param point Another point
	 * @return distance
	 */
	public double distanceTo(Point point) {
		return Math.sqrt((point.x - this.x) * (point.x - this.x) + (point.y - this.y) * (point.y - this.y));
	}

	public static void main(String[] args) {
		Point a = new Point(0,0);
		Point b = new Point(1,1);

	}
}