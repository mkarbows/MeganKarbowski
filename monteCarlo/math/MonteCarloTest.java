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


        Polynomial p = new Polynomial(new double[] {1.0, 0.0, 0.0});
        try {
            displaySuccessIfTrue(p.f(1.0) == 1); 
        } catch (Exception e) {
            displayFailure();
        } 

        Polynomial p2 = new Polynomial();
        try {
            displaySuccessIfTrue(p2.f(1.0) == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        Polynomial p3 = new Polynomial(new double[] {2.0});
        try {
            displaySuccessIfTrue(p3.f(1.0) == 2.0);
        } catch (Exception e) {
            displayFailure();
        }

        Polynomial p4 = new Polynomial(new double[] {3.0, 2.0, 2.0});
        try {
            displaySuccessIfTrue(p4.f(1.0) == 7.0);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(p4.f(2.0) == 18.0);
        } catch (Exception e) {
            displayFailure();
        }

        Polynomial p5 = new Polynomial(new double[] {2.0, 2.0, 2.0, 2.0});
        try {
            displaySuccessIfTrue(p5.f(2.0) == 30);
        } catch (Exception e) {
            displayFailure();
        }

        Polynomial p6 = new Polynomial(new double[] {30.0, 30.0, 30.0, 3.0});
        try {
            displaySuccessIfTrue(p6.f(2.0) == 423);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(p6.f(30.0) == 837903);
        } catch (Exception e) {
            displayFailure();
        }

        Polynomial p7 = new Polynomial(new double[] {0.5, 0.25, 0.5});
        try {
            displaySuccessIfTrue(p7.f(3.0) == 5.75);
        } catch (Exception e) {
            displayFailure();
        }

        Polynomial p8 = new Polynomial(new double[] {-4.0, 0});
        try {
            displaySuccessIfTrue(p8.f(2.0) == -8.0);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(p8.f(-2.0) == 8.0);
        } catch (Exception e) {
            displayFailure();
        }

        Polynomial p9 = new Polynomial(new double[] {-3.0, -3.0, -3.0});
        try  {
            displaySuccessIfTrue(p9.f(2.0) == -21);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(p9.f(-2.0) == -9);
        } catch (Exception e) {
            displayFailure();
        }

        Polynomial p10 = new Polynomial(new double[] {4.0, 5.0, 0, 1.0});
        try {
            displaySuccessIfTrue(p10.f(2.0) == 53);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(p10.f(-2.0) == -11);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(p10.f(0.0) == 1.0);
        } catch (Exception e) {
            displayFailure();
        }

        Polynomial p11 = new Polynomial(new double[] {0.0});
        try {
            displaySuccessIfTrue(p11.f(1.0) == 0.0);
        } catch (Exception e) {
            displayFailure();
        }

        Polynomial p12 = new Polynomial(new double[] {3.0, 0.0, 0.0, 0.0, 0.0, 0.0});
        try {
            displaySuccessIfTrue(p12.f(2.0) == 96);
        } catch (Exception e) {
            displayFailure();
        }
        try {
            displaySuccessIfTrue(p12.f(-2.0) == -96);
        } catch (Exception e) {
            displayFailure();
        }

        System.out.println();
    }
}
