package math;

public class MonteCarloIntegrator {

	private Integratable function;
	private long darts = 1000000; 
	private long hits;

    public MonteCarloIntegrator(Integratable function) {
    	this.function = function;
    }

    public double integrate(double lowerBound, double upperBound) {
    	double rangeX = upperBound - lowerBound;
    	double ceiling = 0;
    	double floor = 0;
		int positiveHits = 0; 
		int negHits = 0;		   	
    	for (int i = 0; i < darts; i++) {
    		double y = function.f(lowerBound + (double)(i)/darts * rangeX);
    		if (y > ceiling) {
    			ceiling = y;

    		} else if (y < floor) {
    			floor = y;
    		}
    	}
    	double rangeY = ceiling - floor;
    	for (int i = 0; i < darts; i++) {
			double randomX = Math.random() * rangeX + lowerBound;
			double randomY = Math.random() * rangeY + floor;
			double actualY = function.f(randomX);
			printCoordinates(randomX, randomY, (randomY <= actualY && randomY > 0) || (randomY >= actualY && randomY < 0));
			if (randomY <= actualY && randomY > 0) {
				positiveHits++;
			} else if (randomY >= actualY && randomY < 0) {
				negHits++;
			}
		}
		int hits = positiveHits + negHits;
		double area = (upperBound - lowerBound) * (ceiling - floor);
		double estimateArea = area * ((double)(positiveHits - negHits) / darts);
		return estimateArea;
    }

     

    public double integrate(double lowerBound, double upperBound, long darts) {
    	this.darts = darts;
    	return integrate(lowerBound, upperBound);
    }

    public static void main(String[] args) {
	    try {
	    	if (args.length < 4) {
	    		System.out.println("Please enter at least 4 numbers");
	    		return;
	    	} 
	    	long darts = Long.parseLong(args[0]);
	    	double lowerBound = Double.parseDouble(args[1]);
	    	double upperBound = Double.parseDouble(args[2]);
	    	int numOfCoeff = args.length - 3;
	    	double[] coeff = new double[numOfCoeff];
	    	for (int i = 3; i < args.length; i++) {
	    		coeff[i - 3] = Double.parseDouble(args[i]);
	    	}
	    	Integratable p = new Polynomial(coeff);
    		MonteCarloIntegrator myIntegrator = new MonteCarloIntegrator(p);

    		System.out.println("start");
    		double estimate1 = myIntegrator.integrate(lowerBound, upperBound, darts);
    		System.out.println("end");
    		System.out.println("f(x) = " + p.toString());
    		System.out.println("Number of estimate: " + estimate1);
    		System.out.println("Number of darts: " + darts);
	    } catch (IllegalArgumentException e) {
	    	System.out.println("Please enter at least 4 numbers and only numbers");
	    	return;
	    }
    }

    private static void printCoordinates(double x, double y, boolean in) {
        System.out.println(x + " " + y + " " + (in ? "in" : "out"));
    }
}
