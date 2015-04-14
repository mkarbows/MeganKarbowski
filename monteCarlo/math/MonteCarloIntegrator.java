package math;

public class MonteCarloIntegrator {

    // TODO: Add instance variables, constructors and methods.
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
    	double rangeY = ceiling - floor;
    	for (int i = 0; i < 100; i++) {
    		double y = function.f(lowerBound + (i/100) * rangeX);
    		if (y > ceiling) {
    			ceiling = y;
    		} else if (y < floor) {
    			floor = y;
    		}
    	}
    	for (int i = 0; i < darts; i++) {
			double randomX = Math.random() * rangeX + lowerBound;
			double randomY = Math.random() * rangeY + floor;
			double actualY = function.f(randomX);
			printCoordinates(randomX, randomY, randomY <= actualY);
			if (randomY <= actualY) {
				hits++;
			}
		}
		return hits;
    }

    public double integrate(double lowerBound, double upperBound, long darts) {
    	this.darts = darts;
    	return integrate(lowerBound, upperBound);
    }

    public static void main(String[] args) {
    	if (args.length < 4) {
    		System.out.println("Please enter at least 3 numbers");
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
    	System.out.println("Number of darts: " + darts);
    	System.out.println("Number of hits: " + myIntegrator.hits); //why won't this print out the hits

    }

    private static void printCoordinates(double x, double y, boolean in) {
        System.out.println(x + " " + y + " " + (in ? "in" : "out"));
    }
}
