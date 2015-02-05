public class ExtraCreditTest {

    public static void main(String[] args) {
        substringCountTest();
        areAnagramsTest();
    }

    public static void substringCountTest() {
        System.out.println("Tests for substringCount()");
        try {

            System.out.println("Test #1:");
            int count1 = StrungOut.substringCount("Halal", "al");
            if (count1 == 2) {
                System.out.println("success");
            } else {
                System.out.println("failure: wrong answer");
            }

            System.out.println("Test #2:");
            int count2 = StrungOut.substringCount("xx", "Hixxxhi");
            if (count2 == 2) {
                System.out.println("success");
            } else {
                System.out.println("failure: wrong answer");
            }

            System.out.println("Test #3:");
            int count3 = StrungOut.substringCount("Test", "123");
            if (count3 == 0) {
                System.out.println("success");
            } else {
                System.out.println("failure: wrong answer");
            }

            System.out.println("Test #4:");
            int count4 = StrungOut.substringCount("Test", "Test");
            if (count4 == 1) {
                System.out.println("success");
            } else {
                System.out.println("failure: wrong answer");
            }

            System.out.println("Test #5:");
            int count5 = StrungOut.substringCount("", "123");
            if (count5 == 0) {
                System.out.println("success");
            } else {
                System.out.println("failure: wrong answer");
            }

        } catch (Exception e) {
            System.out.println("failure: Exception");
        }
        //Blank line after tests
        System.out.println();
    }

    public static void areAnagramsTest() {
        System.out.println("Tests for areAnagrams()");
        try {
            System.out.println("Test #1:");
            boolean b1 = StrungOut.areAnagrams("software", "swear oft");
            if (b1) {
                System.out.println("success");
            } else {
                System.out.println("failure: wrong answer");
            }

            System.out.println("Test #2:");
            boolean b2 = StrungOut.areAnagrams("Parliament!", "Partial Men.");
            if (b2) {
                System.out.println("success");
            } else {
                System.out.println("failure: wrong answer");
            }

            System.out.println("Test #3:");
            boolean b3 = StrungOut.areAnagrams("Burr", "Burb");
            if (!b3) {
                System.out.println("success");
            } else {
                System.out.println("failure: wrong answer");
            }

            System.out.println("Test #4:");
            boolean b4 = StrungOut.areAnagrams("Burb", "Burr");
            if (!b4) {
                System.out.println("success");
            } else {
                System.out.println("failure: wrong answer");
            }

            System.out.println("Test #5:");
            boolean b5 = StrungOut.areAnagrams("", "blah");
            if (!b5) {
                System.out.println("success");
            } else {
                System.out.println("failure: wrong answer");
            }

        } catch (Exception e) {
            System.out.println("failure: Exception");
        }
        //Blank line after tests
        System.out.println();
    }
}
