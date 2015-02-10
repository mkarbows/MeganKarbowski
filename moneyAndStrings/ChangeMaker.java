public class ChangeMaker {
	public static int getQuarters(int cents) {
		return cents / 25; 
	}
	public static int getDimes(int cents) {
		return cents / 10;
	}
	public static int getNickels(int cents) {
		return cents / 5;
	}
	public static int getPennies(int cents) {
		return cents / 1;
	}
	public static int[] getChange(int cents) {
		int[] changeArray = new int[4];
		changeArray[0] = getQuarters(cents);
		cents %= 25;
		changeArray[1] = getDimes(cents);
		cents %= 10;
		changeArray[2] = getNickels(cents);
		cents %= 5;
		changeArray[3] = getPennies(cents);
		cents %= 1;
			return changeArray;	
	}
	public static void main(String args[]) {
		try {
			int number = Integer.parseInt(args[0]);
			if (number < 0) {
				System.out.println("Cannot make change for negative cents.");
			} 
			else {
				int[] finalArray = getChange(number);
				System.out.println("Quarters: " + finalArray[0]);
				System.out.println("Dimes: " + finalArray[1]);
				System.out.println("Nickels: " + finalArray[2]);
				System.out.println("Pennies: " + finalArray[3]);
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Supplied value is not an integer.");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Usage: java ChangeMaker <amount in cents>");
		}
	}
}
