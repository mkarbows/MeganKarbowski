package math;

public class Exponent {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("...");
			return;
		}
		BFInt base = new BFInt(args[0]);
		BFInt power = new BFInt(args[1]);
		BFInt result = new BFInt(base.toString());
		if (power.equals(BFInt.ZERO)) {
			System.out.println("1"); //will always be 1
			return;
		} 
		for (BFInt i = new BFInt("1"); i.isLessThan(power); i = i.plus(BFInt.ONE)) {
			result = result.times(base);
		}
		System.out.println(result.toString());
	}
}
