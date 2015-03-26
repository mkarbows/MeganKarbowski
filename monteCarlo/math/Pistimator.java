package math;

/**
 * Estimates pi by inscribing a circle of radius 1 in a square of side length 2.
 * A given number of "darts" (points) will then be thrown randomly at the square, and
 * the ratio of darts inside the circle to total darts thrown (plus some algebra)
 * will be used to estimate pi.
 */
public class Pistimator {

    // TODO: Add instance variables, constructors and methods.

    private static void printCoordinates(double x, double y, boolean in) {
        System.out.println(x + " " + y + " " + (in ? "in" : "out"));
    }
}
