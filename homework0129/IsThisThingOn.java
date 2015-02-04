public class IsThisThingOn {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("no. please enter a string");
		}
		for (int i=0; i< args.length; i++) {
			System.out.println(countTheVowels(args[i]));
		}
	}
	
	public static int countTheVowels(String text) {
		int count = 0;
		for (int index = 0; index < text.length(); index++) {
			char letter = text.charAt(index);
			if (letter == 'a'|| letter == 'A' || letter == 'e' || letter == 'E' || letter == 'i' || letter == 'I' || letter == 'o' || letter == 'O' || letter == 'u' || letter == 'U') {
				count += 1;
			}
		}
	return count;
	
	}
}
