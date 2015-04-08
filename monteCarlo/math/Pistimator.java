package math;

/**
 * Estimates pi by inscribing a circle of radius 1 in a square of side length 2.
 * A given number of "darts" (points) will then be thrown randomly at the square, and
 * the ratio of darts inside the circle to total darts thrown (plus some algebra)
 * will be used to estimate pi.
 */
public class Pistimator {

    // TODO: Add instance variables, constructors and methods.
    private long darts;
    private long hits;

    public Pistimator() {
    	this(100000);
    }

    public Pistimator(long darts) {
    	hits = 0;
    	this.darts = darts;
    }

    public double estimatePi() {
    	System.out.println("start");
    	for (int i = 0; i < darts; i++) {
			double x = 2 * Math.random() - 1;
			double y = 2 * Math.random() - 1;
			printCoordinates(x, y, x*x + y*y <= 1); 
			if (x*x + y*y <= 1) {
				hits++; 
			} 
		}
		System.out.println("end");	 
		return 4 * ((double) hits / (double) darts);
    }

    public long getHits() {
    	return hits;
    }

    public static void main(String[] args) {
	    try {
	    	
	    	Pistimator newPi;
	    	double piEstimate;
	    	if (args.length == 0) {
	    		newPi = new Pistimator();
	    	} else {
	    		newPi = new Pistimator(Long.parseLong(args[0]));
	    	}
	    	piEstimate = newPi.estimatePi();
	    	System.out.println("Number of hits: " + newPi.getHits());
	    	System.out.println("Number of darts: " + newPi.darts);
	    	System.out.println("Pi Estimate: " + piEstimate);
	    } catch (Exception e) {
	    	System.out.println("This isn't a long/int");
	    }
    }

    private static void printCoordinates(double x, double y, boolean in) {
        System.out.println(x + " " + y + " " + (in ? "in" : "out"));
    }
}
