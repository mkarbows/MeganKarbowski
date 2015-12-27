import java.util.Arrays;
import java.util.ArrayList;

public class BaseConverter {

public static long[] startingNumber;
public static String[] startingNumberString;
public static long startingBase;
public static long newBase;
    
    public static boolean validArgs (String[] args) {
        long convertedBase;
        startingBase = Long.parseLong(args[1]);

        if (args.length < 3) {
        	newBase = 10;
        } else {   
        	newBase = Long.parseLong(args[2]);
    	}
		
        if (args.length > 3) throw new IllegalArgumentException();
        if (args[0].charAt(0) != '[') throw new IllegalArgumentException();
        if (startingBase==1 || newBase==1) throw new IllegalArgumentException();
      
        int bracketCounter = 0;
        int digitCounter = 0;
        
        for (int i = 0; i < args[0].length(); i++) {
        	 if (args[0].charAt(i) == startingBase) {
        		throw new IllegalArgumentException();
        	}   
        	else if (args[0].charAt(i) == '[') {
        		bracketCounter++;
        		if (bracketCounter > 1) throw new IllegalArgumentException();
        	} else if (args[0].charAt(i) == ']') {
        		bracketCounter--;
        		if (bracketCounter < 0) throw new IllegalArgumentException();

        		if (digitCounter == 0) throw new IllegalArgumentException();
        		digitCounter = 0;
        	} else if (Character.isDigit(args[0].charAt(i))) {
        		digitCounter++;
        	} else if (!Character.isDigit(args[0].charAt(i))) {
        		throw new IllegalArgumentException();
        	} 	
        } 
        if (bracketCounter != 0) throw new IllegalArgumentException();

        // start extracting values here
        startingNumberString = args[0].substring(1, args[0].length()-1).split("\\]\\[");
        startingNumber = new long[startingNumberString.length];
        for (int i = 0; i < startingNumberString.length; i++) {
        	startingNumber[i] = Long.parseLong(startingNumberString[i]);   
        	if (startingNumber[i] >= startingBase) {
        		throw new IllegalArgumentException();
        	}     	
        }
        //System.out.println(Arrays.toString(startingNumberString));
        return true;
    }
            
    public static long sum;
    public static long convertTen(long[] startingNumber, long startingBase) {
    	if (startingNumber.equals(1)) {
    		sum = 1;
    	} else if (startingNumber.equals(0)) {
    		sum = 0;   	
    	} 
    	else {
	    	sum = 0;
    		for(int i = 0; i < startingNumber.length; i++) {
    			long num = startingNumber[i] * ((long) Math.pow(startingBase, (startingNumber.length -1) -i));
    			sum += num;
    		}
    	}
    	return sum;
    }

    public static ArrayList<Long> finalSum;
    public static ArrayList<Long> newBaseConv(long sum, long newBase) {
    	finalSum = new ArrayList<>();
    	int i = 0;
    	long j = 0;
    	while ((long) Math.pow(newBase, i + 1) <= sum) {
    			i++;
    		} 
    	while (i >= 0) {
    		j = 0;
    		long newBasePower;
    		newBasePower = (long) Math.pow(newBase, i);

    		while (((j + 1) * newBasePower) <= sum) {
    			j++;
    		}
    		sum -= ((j) * newBasePower);
    		finalSum.add(j);
    		i--;
    	}   	
    	return finalSum;
    } 

    public static void main (String[] args) {
        if (!validArgs (args)) {
            throw new IllegalArgumentException();
        }
        else {
            sum = convertTen(startingNumber, startingBase);
            //System.out.println("Base Ten Converted Number: " + sum);

            finalSum = newBaseConv(sum, newBase);
            //System.out.println("New Base Conversion: " + finalSum);
  
            String answer = "";
            for (int i = 0; i < finalSum.size(); i++) {
            	answer = answer + "[" + finalSum.get(i) + "]";
            }
            System.out.println(answer);
        }
    }
}
