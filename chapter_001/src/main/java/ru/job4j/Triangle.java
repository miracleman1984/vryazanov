package ru.job4j;

/**
 * Triangle class keeps triangle properties.
 * @author Vitaly Ryazanov miracleman@mail.ru
 * @since 03.01.2017
 * @version 1
 */
public class Triangle {
	/**
	 * Store point A.
	 */
	private Point a;
	/**
	 * Store point B.
	 */
	private Point b;
	/**
	 * Store point C.
	 */
	private Point c;
	/**
	 * Triangle class constructor.
	 * @param a Point A
	 * @param b Point B
	 * @param c Point C
	 */
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	 * Calculate the triangle area if this triangle exists or -1 in another case.
	 * @return the triangle area
	 */
	public double area() {
		double result = -1d;
		double ab = this.a.distanceTo(this.b);
		double bc = this.b.distanceTo(this.c);
		double ac = this.a.distanceTo(this.c);
		double p = (ab + bc + ac) / 2d;
		if (ab != bc + ac && bc != ab + ac && ac != bc + ab) {
			result = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
		}
		return result;
	}
}