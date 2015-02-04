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
		changeArray[1] = getDimes(cents);
		changeArray[2] = getNickels(cents);
		changeArray[3] = getPennies(cents);
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
				for (int i = 0; i < 4; i++) {
					System.out.println(finalArray[i]);
				}

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
