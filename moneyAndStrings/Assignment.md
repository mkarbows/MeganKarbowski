# Money and Strings
## Due 02/10/2015

For this assignment, you'll be creating two class files.

### Money

The first class should be called *ChangeMaker* and must contain the following methods:

* **public static int getQuarters(int cents):** returns the number of quarters needed if you were providing change for the given amount in cents.
* **public static int getDimes(int cents):** returns the number of dimes needed.
* **public static int getNickels(int cents):** returns the number of nickels needed.
* **public static int getPennies(int cents):** discards all input and returns an ASCII drawing of a robot. (But seriously, you get it.)
* **public static int[] getChange(int cents):** returns a 4-integer array indicating the number of coins needed to make change for the given amount in cents. The first element should hold the number of quarters, the second element should hold the number of dimes, the third element should hold the number of nickels, and finally the fourth element should hold the number of pennies.
* **public static void main(String[] args)** displays the change to be made for the given amount in cents (args[0]).
* If the user does not supply any arguments, display the message:
    * *Usage: java ChangeMaker \<amount in cents>*
* If the user enters a decimal number or any other non-integer, display the message:
  * *Supplied value is not an integer.* (Or something similar)
* If the user enters a negative integer, display the message:
  * *Cannot make change for negative cents.* (Or something similar)
* Ignore all other arguments, if any.
* If the entered amount is valid, display the change required, one line per denomination. For example, the output for *java ChangeMaker 146* would look like this:
  * *Quarters: 5
    Dimes: 2
    Nickels: 0
    Pennies: 1*

### Strings

The second class should be called *StrungOut* and contain the following methods:

* **public static String reverse(String text):** returns the reverse of the given string. For example "abc" -> "cba".
* **public static boolean isPalindrome(String text):** returns true if the given string is a palindrome (valid palindromes: "racecar", "X", "33", "52725", "Mom").
* **public static String evensOnly(String text):** returns only the characters with an even index as a new string. For example, "REHEARSALS" -> "RHASL", "A" -> "A", "hi" -> "h".
* **public static String oddsOnly(String text)** returns only the characters with an odd index as a new string. For example, "REHEARSALS" -> "EERAS", "A" -> "", "hi" -> "i".
* **public static void main(String[] args)** displays each of the above string methods applied to the string in (args[0]). For example, output for *java StrungOut TestString* should look something like this:
  * *Reverse: gnirtStseT
     Palindrome: false
     Evens: TsSrn
     Odds: ettig*
* If the user does not supply any arguments, display the message:
  * *Usage: java StrungOut \<some string>*
* All other input should be ignored.

### Extra Credit

If you've finished the above methods, you can try your hand at these two optional ones
(add them to StrungOut.java):

* **public static int substringCount(String string1, String string2):** returns the number of times the smaller (or equally sized) string appears in the other. For example, *substringCount("Halal", "al")* returns 2, *substringCount("xx", "Hixxxhi")* returns 2, *substringCount("Test", "123")* returns 0, *substringCount("Test", "Test")* returns 1, and if either string is empty, it returns 0.  
        **Note:** This method should be case sensitive—*substringCount("Hahaha", "ha")* should return only 2.
* **public static boolean areAnagrams(String string1, String string2):** returns true if the two strings are anagrams of each other. In other words, it returns true if string2 is a rearrangement of string1's letters (and/or digits). Valid anagrams: "software" and "swear oft", "Parliament" and "Partial Men", "William Shakespeare" and " I am a weakish speller.").  
        **Note:** This method should ignore case, white space, and punctuation.
* A test file is included (ExtraCreditTest.java) for these methods, but you can also add these lines to your main method in StrungOut.java to call the functions with args[0] and args[1]:  

#

    if (args.length < 2) {
        System.out.println("Need one more argument for substringCount" +
            " and areAanagrams.");
    } else {
        System.out.println("Substring Count: " +
            substringCount(args[0], args[1]));
        System.out.println("Anagrams: " + areAnagrams(args[0], args[1]));
    }
