package clock;

public class ClockTest {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {

        test_clockConstructors();
        test_tick();
        test_clockSolverConstructors();
        test_foundAngle();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    /**
     * Tests to see if the clock constructors are working properly.
     * In other words, test to see if hours, minutes, seconds, grain, and
     * secondsPassed are getting initialized properly. Also check to make sure
     * an IllegalArgumentException is being thrown when input is invalid.
     */
    private static void test_clockConstructors() {
        System.out.println("Testing Clock Constructors...");

        // TODO: It's lonely here. Add some tests.

        System.out.println();
    }

    /**
     * Test the tick method. Make sure that hours, minutes, seconds, and secondsPassed
     * fields are all being incremented properly when the clock ticks. This includes
     * testing that seconds and minutes reset after 60 and hours resets after 12.
     */
    private static void test_tick() {
        System.out.println("Testing tick...");

        // TODO: It's lonely here. Add some tests.

        System.out.println();
    }

    /**
     * Tests to make sure that the ClockSolver object is being constructed properly.
     * This means ensuring the clock is being initialized properly, the grain, and
     * also the angleToFind and angleBetween, and that an IllegalArgumentException is
     * being thrown when the angleToFind and grain are invalid.
     */
    private static void test_clockSolverConstructors() {
        System.out.println("Testing ClockSolver Constructors...");

        // TODO: It's lonely here. Add some tests.

        System.out.println();
    }

    /**
     * Tests that foundAngle returns true when the angleToFind is within the proper
     * margin of error, and that it returns false when it isn't.
     */
    private static void test_foundAngle() {
        System.out.println("Testing foundAngle...");

        // TODO: It's lonely here. Add some tests.

        System.out.println();
    }

    /**
     * Returns true if the real numbers are within 0.00001 of each other.
     * Helps compare "equality" of two double values since they aren't exact.
     * Don't use == when comparing doubles, but rather, call this method.
     */
    private static boolean compareDoubles(double real1, double real2) {
        return Math.abs(real1 - real2) < 0.00001;
    }

}
