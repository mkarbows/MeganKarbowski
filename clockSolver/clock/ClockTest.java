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
            displaySuccessIfTrue(testClock.getHours() == 12 && testClock.getMinutes() == 0 &&
                testClock.getSeconds() == 0 && testClock.getGrain() == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests the second clock (Clock(int hours))
        System.out.println("Testing Clock(int hours)");
        Clock testClock2 = new Clock(2);
        try {
            displaySuccessIfTrue(testClock2.getHours() == 2 && testClock2.getMinutes() == 0 && 
                testClock2.getSeconds() == 0 && testClock2.getGrain() == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests the third clock (Clock(int hours, int minutes))
        System.out.println("Testing Clock(int hours, int minutes)");
        Clock testClock3 = new Clock(2, 20);
        try {
            displaySuccessIfTrue(testClock3.getHours() == 2 && testClock3.getMinutes() == 20 &&
                testClock3.getSeconds() == 0 && testClock3.getGrain() == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests the fourth clock (Clock(int hours, int minutes, double seconds))
        System.out.println("Testing Clock(int hours, int minutes, double seconds)");
        Clock testClock4 = new Clock(2, 20, 30.0);
        try {
            displaySuccessIfTrue(testClock4.getHours() == 2 && testClock4.getMinutes() == 20 &&
                testClock4.getSeconds() == 30.0 && testClock4.getGrain() == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests the fifth clock (Clock(int hours, int minutes, double seconds, double grain))
        System.out.println("Testing Clock(int hours, int minutes, double seconds, double grain)");
        Clock testClock5 = new Clock(2, 20, 30.0, 5.5);
        try {
            displaySuccessIfTrue(testClock5.getHours() == 2 && testClock5.getMinutes() == 20 &&
                testClock5.getSeconds() == 30.0 && testClock5.getGrain() == 5.5);
        } catch (Exception e) {
            displayFailure();
        }

        //tests the secondsPassed()...
        System.out.println("Testing secondsPassed()");
        Clock secPassClock = new Clock(12, 40, 0.0, 6.0);
        try {
            for (int i = 0; i < 3; i++) {
                secPassClock.tick();
            }
            displaySuccessIfTrue(secPassClock.getSecondsPassed() == 18.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests secondsPassed with half seconds
        Clock secPassClock2 = new Clock(12, 40, 0.0, 0.5);
        try {
            for (int i = 0; i < 4; i++) {
                secPassClock2.tick();
            }
            displaySuccessIfTrue(secPassClock2.getSecondsPassed() == 2.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests secondsPassed with small seconds...
        Clock secPassClock3 = new Clock(12, 40, 0.0, 0.15);
        try {
            for (int i = 0; i < 3; i++) {
                secPassClock3.tick();
            }
            displaySuccessIfTrue(secPassClock3.getSecondsPassed() == 0.45);
        } catch (Exception e) {
            displayFailure();
        }

        //tests secondsPassed with big seconds...
        Clock secPassClock4 = new Clock(12, 40, 0.0, 40.0);
        try {
            for (int i = 0; i < 3; i++) {
                secPassClock4.tick();
            }
            displaySuccessIfTrue(secPassClock4.getSecondsPassed() == 120.0);
        } catch (Exception e) {
            displayFailure();
        }

        //also need to make sure and IllegalArgumentException is being thrown when input is invalid

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

        //this tests a basic clock at time 2:30:00
        Clock tickClock = new Clock(2, 30, 0.0, 1.0);
        tickClock.tick();
        try {
            displaySuccessIfTrue(tickClock.getHours() == 2 && tickClock.getMinutes() == 30 &&
                tickClock.getSeconds() == 1.0 && tickClock.getGrain() == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests clock with 59 seconds and grain=2.0
        Clock tickClock2 = new Clock(2, 30, 59.0, 2.0);
        tickClock2.tick();
        try {
            displaySuccessIfTrue(tickClock2.getHours() == 2 && tickClock2.getMinutes() == 31 && 
                tickClock2.getSeconds() == 1.0 && tickClock2.getGrain() == 2.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests clock with 59 minutes and ...
        Clock tickClock3 = new Clock(2, 59, 58.0, 2.0);
        tickClock3.tick();
        try {
            displaySuccessIfTrue(tickClock3.getHours() == 3 && tickClock3.getMinutes() == 0 &&
                tickClock3.getSeconds() == 0.0 && tickClock3.getGrain() == 2.0);
        } catch (Exception e) {
            displayFailure();
        }

        //tests clock with 12 hours and 59 minutes and 58 seconds w/ grain of 2...
        Clock tickClock4 = new Clock(12, 59, 58.0, 2.0);
        tickClock4.tick();
        try {
            displaySuccessIfTrue(tickClock4.getHours() == 1 && tickClock4.getMinutes() == 0 &&
                tickClock4.getSeconds() == 0.0 && tickClock4.getGrain() == 2.0);
        } catch (Exception e) {
            displayFailure();
        }


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
