public class StrungOut {
	public static String reverse(String text) {
		String reverseText = "";
		for (int i = text.length() - 1; i >= 0; i--) {
			reverseText = reverseText + text.charAt(i);	
		}
		return reverseText;
	}
	public static boolean isPalindrome(String text) {
		String reversed = reverse(text);
		return reversed.equals(text);
	}
	public static String evensOnly(String text) {
		String evenText = "";
		for (int i = 0; i < text.length(); i += 2) {
			evenText = evenText + text.charAt(i);
		}
		return evenText;
	}
	public static String oddsOnly(String text) {
		String oddText = "";
		for (int i = 1; i < text.length(); i += 2) {
			oddText = oddText + text.charAt(i);
		}
		return oddText;
	}
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java StrungOut <some string>");
		}
		else {
			System.out.println("Reverse: " + reverse(args[0]));
			System.out.println("Palidrome: " + isPalindrome(args[0]));
			System.out.println("Evens: " + evensOnly(args[0]));
			System.out.println("Odds: " + oddsOnly(args[0]));
		}
	}	
}
