package math;

public class Polynomial implements Integratable {

    // TODO: Add instance variables, constructors and methods.
	private double[] coefficients;

    public Polynomial() {
    	this.coefficients = new double[] {1.0};
    }

    public Polynomial(double[] coefficients) {
    	this.coefficients = coefficients;
    }

    public double f(double x) {
    	int power = coefficients.length - 1;
    	double result = 0;
    	for (int i = 0; i < coefficients.length; i++) {
    		result += coefficients[i] * Math.pow(x, power);
    		power --;
    	}
    	return result;
	}
}



