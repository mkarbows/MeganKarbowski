package math;

public class Polynomial implements Integratable {

	private double[] coefficients;

    public Polynomial() {
    	this.coefficients = new double[] {1.0};
    }

    public Polynomial(double[] coefficients) {
    	this.coefficients = coefficients;
    }

    public String toString() {
    	String result = "";
    	int power = coefficients.length - 1;
    	for (int i = 0; i < coefficients.length; i++) {
    		double currentNum = coefficients[i];
    		String stringifiedCurrentNumber = currentNum + "";
    		if (currentNum % 1 == 0) {
    			int idxOfDecimal = stringifiedCurrentNumber.indexOf('.');
    			stringifiedCurrentNumber = stringifiedCurrentNumber.substring(0,idxOfDecimal);
    		}
    		if (i != 0) {
    			if (currentNum < 0) {
    				stringifiedCurrentNumber = stringifiedCurrentNumber.substring(1);
    			}
    		}
    		if (currentNum != 0) {
    			String prefix = currentNum <= 0 ? " - " : " + ";
    			
    			int idxOfDecimal = stringifiedCurrentNumber.indexOf('.');
    			result += (i > 0 ? prefix : "") + stringifiedCurrentNumber;
    			if (power > 0) {
    				result += "x";
    				if (power > 1){
    					result += "^" + power;
    				}
    			}
    		}
    		power--;
    	}
    	return result;
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
