public class StrungOut {
	public static String reverse(String text) {
		return new StringBuilder(text).reverse().toString();
	}
	public static boolean isPalindrome(String text) {
		int n = text.length();
		for (int i = 0; i < (n/2) + 1; ++i) {
			if (text.charAt(i) != text.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
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
}
