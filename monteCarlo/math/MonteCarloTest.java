package math;

public class MonteCarloTest {
    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {

        test_polynomial();

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

    private static void test_polynomial() {
        System.out.println("Testing Polynomial...");

        // TODO: Add some polynomial tests.

        System.out.println();
    }

}
