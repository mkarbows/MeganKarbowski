class StrungOutTest {
    public static void main(String[] args){
        reverseTest();
        isPalindromeTest();
        evensOnlyTest();
        oddsOnlyTest();
    }

    public static void reverseTest() {
        System.out.println("Tests for reverse():");
        try {

            System.out.println("Test #1:");
            String s1 = StrungOut.reverse("abc");
            if (s1.equals("cba")){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }

            System.out.println("Test #2:");
            String s2 = StrungOut.reverse("a b c");
            if (s2.equals("c b a")){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }       

            System.out.println("Test #3:");
            String s3 = StrungOut.reverse("432");
            if (s3.equals("234")){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }

        } catch (Exception e) {
            System.out.println("False: Exception");
        }
        //Blank line after tests
        System.out.println();
    }

    public static void isPalindromeTest() {
        System.out.println("Tests for isPalindrome():");
        try {

            System.out.println("Test #1:");
            boolean b1 = StrungOut.isPalindrome("racecar");
            if (b1){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }

            System.out.println("Test #2:");
            boolean b2 = StrungOut.isPalindrome("33");
            if (b2){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }       

            System.out.println("Test #3:");
            boolean b3 = StrungOut.isPalindrome("1212");
            if (b3 == false){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }

        } catch (Exception e) {
            System.out.println("False: Exception");
        }
        //Blank line after tests
        System.out.println();
    }

    public static void evensOnlyTest() {
        System.out.println("Tests for evensOnly():");
        try {

            System.out.println("Test #1:");
            String s1 = StrungOut.evensOnly("REHEARSALS");
            if (s1.equals("RHASL")){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }

            System.out.println("Test #2:");
            String s2 = StrungOut.evensOnly("A");
            if (s2.equals("A")){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }       

            System.out.println("Test #3:");
            String s3 = StrungOut.evensOnly("hi");
            if (s3.equals("h")){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }

        } catch (Exception e) {
            System.out.println("False: Exception");
        }
        //Blank line after tests
        System.out.println();
    }

    public static void oddsOnlyTest() {
        System.out.println("Tests for oddsOnly():");
        try {

            System.out.println("Test #1:");
            String s1 = StrungOut.oddsOnly("REHEARSALS");
            if (s1.equals("EERAS")){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }

            System.out.println("Test #2:");
            String s2 = StrungOut.oddsOnly("A");
            if (s2.equals("")){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }       

            System.out.println("Test #3:");
            String s3 = StrungOut.oddsOnly("hi");
            if (s3.equals("i")){
                System.out.println("True");
            } else {
                System.out.println("False: Wrong Answer");
            }

        } catch (Exception e) {
            System.out.println("False: Exception");
        }
        //Blank line after tests
        System.out.println();
    }


}
