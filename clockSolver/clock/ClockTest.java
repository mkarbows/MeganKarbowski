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
        
        //tests the first clock (public Clock())
        System.out.println("Testing Clock()");
        Clock testClock = new Clock();
        try {
            displaySuccessIfTrue(testClock.getHours() == 12);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock.getMinutes() == 0);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock.getSeconds() == 0);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock.getGrain() == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests the second clock (Clock(int hours))
        System.out.println("Testing Clock(int hours)");
        Clock testClock2 = new Clock(2);
        try {
            displaySuccessIfTrue(testClock2.getHours() == 2);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock2.getMinutes() == 0);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock2.getSeconds() == 0);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock2.getGrain() == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests the third clock (Clock(int hours, int minutes))
        System.out.println("Testing Clock(int hours, int minutes)");
        Clock testClock3 = new Clock(2, 20);
        try {
            displaySuccessIfTrue(testClock3.getHours() == 2);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock3.getMinutes() == 20);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock3.getSeconds() == 0);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock3.getGrain() == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests the fourth clock (Clock(int hours, int minutes, double seconds))
        System.out.println("Testing Clock(int hours, int minutes, double seconds)");
        Clock testClock4 = new Clock(2, 20, 30);
        try {
            displaySuccessIfTrue(testClock4.getHours() == 2);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock4.getMinutes() == 20);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock4.getSeconds() == 30);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock4.getGrain() == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests the fifth clock (Clock(int hours, int minutes, double seconds, double grain))
        System.out.println("Testing Clock(int hours, int minutes, double seconds, double grain)");
        Clock testClock5 = new Clock(2, 20, 30, 5.5);
        try {
            displaySuccessIfTrue(testClock5.getHours() == 2);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock5.getMinutes() == 20);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock5.getSeconds() == 30);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(testClock5.getGrain() == 5.5);
        } catch (Exception e) {
            displayFailure();
        }


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
