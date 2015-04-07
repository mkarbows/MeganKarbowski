package math;

public class Fibonacci {
	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				System.out.println("Please enter a number");
				return;
			}
		
			BFInt number = new BFInt(args[0]);
			if (number.equals(BFInt.ONE)) {
				System.out.println("0");
				return;
			} else if (number.equals(new BFInt(2))) {
				System.out.println("1");
				return;
			}
			BFInt firstSeed = new BFInt("0");
			BFInt secondSeed = new BFInt("1");

			for (BFInt i = new BFInt(2); i.isLessThan(number); i = i.plus(new BFInt(1))) {
				BFInt sum = firstSeed.plus(secondSeed);
				firstSeed = new BFInt(secondSeed.toString());
				secondSeed = new BFInt(sum.toString());
			}
			System.out.println(secondSeed);
		} catch (IllegalArgumentException e) {
			System.out.println("Please enter a number");
			return;
		}
	}
}
