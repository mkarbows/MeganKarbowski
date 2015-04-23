package money;

import util.IntTuple;
import static money.DynamicChangeMaker.makeChange;

public class DynamicChangeMakerTest {
    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {

        test_makeChange();

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

    private static void test_makeChange() {
        System.out.println("Test makeChange...");

        IntTuple denominations = new IntTuple(new int[] {
            1, 5, 10, 25
        });
        IntTuple answer = new IntTuple(new int[] {
            1, 0, 2, 5
        });
        try {
            displaySuccessIfTrue(makeChange(denominations, 146).equals(answer));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations, 146));

        IntTuple denominations1 = new IntTuple(new int[] {
            3, 7, 10
        });
        IntTuple answer1 = new IntTuple(new int[] {
            0, 2, 1
        });
        try {
            displaySuccessIfTrue(makeChange(denominations1, 24).equals(answer1));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations1, 24));

        IntTuple denominations2 = new IntTuple(new int[] {
            1, 4, 9, 12
        });
        IntTuple answer2 = new IntTuple(new int[] {
            2, 0, 0, 2
        });
        try {
            displaySuccessIfTrue(makeChange(denominations2, 26).equals(answer2));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations2, 26));

        IntTuple denominations3 = new IntTuple(new int[] {
            1, 4, 9, 19
        });
        IntTuple answer3 = new IntTuple(new int[] {
            0, 0, 0, 2
        });
        try {
            displaySuccessIfTrue(makeChange(denominations3, 38).equals(answer3));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations3, 38));

        IntTuple denominations4 = new IntTuple(new int[] {
            7, 8, 3
        });
        IntTuple answer4 = new IntTuple(new int[] {
            0, 0, 4
        });
        try {
            displaySuccessIfTrue(makeChange(denominations4, 12).equals(answer4));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations4, 12));   

        IntTuple denominations5 = new IntTuple(new int[] {
            3, 9, 40
        });
        try {
            displaySuccessIfTrue(makeChange(denominations5, 50)== null);
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations5, 50));   

        IntTuple denominations6 = new IntTuple(new int[] {
            15, 1, 7, 100
        });
        IntTuple answer6 = new IntTuple(new int[] {
            2, 0, 0, 0
        });

        try {
            displaySuccessIfTrue(makeChange(denominations6, 30).equals(answer6));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations6, 30)); 

        IntTuple denominations7 = new IntTuple(new int[] {
            15, 1, 7, 100
        });
        IntTuple answer7 = new IntTuple(new int[] {
            0, 0, 0, 1
        });

        try {
            displaySuccessIfTrue(makeChange(denominations7, 100).equals(answer7));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations7, 100)); 

        IntTuple denominations8 = new IntTuple(new int[] {
            15, 1, 6, 100
        });
        IntTuple answer8 = new IntTuple(new int[] {
            0, 1, 1, 0
        });

        try {
            displaySuccessIfTrue(makeChange(denominations8, 7).equals(answer8));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations8, 7)); 

        IntTuple denominations9 = new IntTuple(new int[] {
            15
        });
        IntTuple answer9 = new IntTuple(new int[] {
            1,
        });

        try {
            displaySuccessIfTrue(makeChange(denominations9, 15).equals(answer9));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations9, 15)); 

        IntTuple denominations10 = new IntTuple(new int[] {
            15, 12
        });
        IntTuple answer10 = new IntTuple(new int[] {
            1, 1
        });

        try {
            displaySuccessIfTrue(makeChange(denominations10, 27).equals(answer10));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations10, 27));

        IntTuple denominations11 = new IntTuple(new int[] {
            15, 12
        });
        

        try {
            displaySuccessIfTrue(makeChange(denominations11, 5)== null);
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations11, 5));

        IntTuple denominations12 = new IntTuple(new int[] {
            15, 12, 4 
        });
        IntTuple answer12 = new IntTuple(new int[] {
            1, 1, 1
        });

        try {
            displaySuccessIfTrue(makeChange(denominations12, 31).equals(answer12));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations12, 31));

        IntTuple denominations13 = new IntTuple(new int[] {
            15, 12, 4, 6
        });
        IntTuple answer13 = new IntTuple(new int[] {
            1, 1, 1, 1
        });

        try {
            displaySuccessIfTrue(makeChange(denominations13, 37).equals(answer13));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations13, 37));

        IntTuple denominations14 = new IntTuple(new int[] {
            30, 12, 4, 6
        });
        IntTuple answer14 = new IntTuple(new int[] {
            33, 0, 1, 1
        });

        try {
            displaySuccessIfTrue(makeChange(denominations14, 1000).equals(answer14));
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println(makeChange(denominations14, 1000));

        System.out.println();
    }
}
