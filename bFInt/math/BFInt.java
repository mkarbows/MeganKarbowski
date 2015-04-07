package math;

//Imported solely for HashCode purposes. Do not use.
import java.util.Arrays;

/**
 * The B stands for Big.
 *
 * Object that represents an arbitrarliy large integer
 * (Max value has around Integer.MAX_INT (~2 billion) digits.
 */
public class BFInt {


    // TODO: Set these.
    /**
     * A constant for a BFInt with a value of 0.
     */
    public static final BFInt ZERO = new BFInt("0");
    /**
    * A constant for a BFInt with a value of -1.
    */
    public static final BFInt NEGATIVE_ONE = new BFInt("-1");
    /**
    * A constant for a BFInt with a value of 1.
    */
    public static final BFInt ONE = new BFInt("1");
    /**
    * A constant for a BFInt with a value of 10.
    */
    public static final BFInt TEN = new BFInt("10");

    // These are the private instance variables for BFInt. You can change these if you
    // have a different idea for how to represent a BFInt object.
    private boolean negative;
    private byte[] digits;

    public BFInt() {
        // TODO: Finish me, pretty please.
        this("0");
    }

    public BFInt(int number) {
        // TODO: Finish me, pretty please.
        this("" + number);
    }

    public BFInt(long number) {
        // TODO: Finish me, pretty please.
        this("" + number);
    }

    public BFInt(short number) {
        // TODO: Finish me, pretty please.
        this("" + number);
    }

    public BFInt(byte number) {
        // TODO: Finish me, pretty please.
        this("" + number);
    }

    public BFInt(BFInt bFInt) {
        // TODO: Finish me, pretty please.
        this("" + bFInt);

    }

    public BFInt(String numberString) {
        // TODO: Finish me, pretty please.
        
            String copyString = numberString;
            copyString = copyString.trim();
            if (copyString.substring(0, 1).equals("-")) {
                negative = true;
                copyString = copyString.substring(1);
            } else if (copyString.substring(0, 1).equals("+")) {
                negative = false;
                copyString = copyString.substring(1);
            } else {
                negative = false;
            }
            String firstChar = copyString.substring(0, 1);
            while (firstChar.equals("0") && copyString.length() != 1) {
                copyString = copyString.substring(1);
                firstChar = copyString.substring(0, 1);
            }
            digits = new byte[copyString.length()];
            for (int i = 0; i < copyString.length(); i++) {
                String currentChar = copyString.substring(copyString.length() - 1 - i, copyString.length() - i);
                try {
                    byte currentDigit = Byte.parseByte(currentChar);
                    digits[i] = currentDigit;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }        
    }

    public boolean isEqualTo(BFInt other) {
        // TODO: Finish me, pretty please.
        if ((this.digits.length != other.digits.length) ||
            (this.negative != other.negative)) {
            return false;
        }
        for (int i = 0; i < other.digits.length; i++) {
            if (this.digits[i] != other.digits[i]) {
                return false;
            }
        }
        return true;
    } 

    public boolean isGreaterThan(BFInt other) {
        // TODO: Finish me, pretty please.
        if ((this.digits.length > other.digits.length && this.negative == other.negative && !this.negative) ||
            (this.negative == other.negative && this.negative && this.digits.length < other.digits.length) ||
            (!this.negative && other.negative)) {
            return true;
        } else if ((this.digits.length < other.digits.length && !this.negative && this.negative == other.negative) ||
            (this.negative == other.negative && this.negative && this.digits.length > other.digits.length) ||
            (this.negative && !other.negative)) {
            return false;
        }
        if (this.digits[0] == 0 && other.negative && this.digits.length == 1) {
            return true;
        }
        if (this.negative == other.negative && !this.negative) {

            for (int i = this.digits.length - 1; i >= 0; i--) {
                if (this.digits[i] > other.digits[i]) { 
                    return true;
                } else if (this.digits[i] < other.digits[i]) {
                    return false;
                }
            } 
            return false;
        }
        if (this.negative == other.negative && this.negative) {
            for (int i = this.digits.length - 1; i >= 0; i--) {
                if (this.digits[i] < other.digits[i]) {
                    return true;
                } else if (this.digits[i] > other.digits[i]) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public boolean isLessThan(BFInt other) {
        // TODO: Finish me, pretty please.
        return !isEqualTo(other) && !isGreaterThan(other);
    }

    /**
     * Returns true if the this BFInt is negative.
     */
     public boolean isNegative() {
        return this.negative;
     }

    /**
     * Returns a new BFInt that is the absoulte value of this BFInt.
     */
    public BFInt abs() {
        // TODO: Finish me, pretty please.
        BFInt absolute = new BFInt(this.toString());
        absolute.negative = false;
        return absolute;
    }

    // TODO: Add missing methods that are in the specs here.

    /**
    * Returns the sum of this BFInt plus the addend.
    */
    public BFInt plus(BFInt addend) {
        // TODO: Finish me, pretty please.
        
        byte carry = 0;
        byte[] sum = new byte[this.digits.length + 1];
        byte[] longer = null;
        byte[] shorter = null;
        boolean negative = false;
       
        if (this.digits.length == addend.digits.length && this.negative == addend.negative) {
            for (int i = 0; i < this.digits.length; i++) {
                sum[i] = (byte) (this.digits[i] + addend.digits[i] + carry);
                carry = (byte) (sum[i] / 10);
                sum[i] = (byte) (sum[i] % 10);
            }
            if (carry > 0) {
                sum[sum.length - 1] = carry;
            }
            if (this.negative) {             
                negative = true;
            }
        } else if (this.digits.length != addend.digits.length && this.negative == addend.negative) {
            if (this.digits.length > addend.digits.length) {
                longer = this.digits;
                shorter = addend.digits;
            } else {
                longer = addend.digits;
                shorter = this.digits;
            }
            sum = new byte[longer.length + 1];
            for (int i = 0; i < shorter.length; i++) { 
                sum[i] = (byte) (longer[i] + shorter[i] + carry);
                carry = (byte) (sum[i] / 10);
                sum[i] = (byte) (sum[i] % 10);
            }
            for (int i = shorter.length; i < longer.length; i++) {
                sum[i] = (byte) (longer[i] + carry);
                carry = (byte) (sum[i] / 10);
                sum[i] = (byte) (sum[i] % 10);
            }
            sum[sum.length - 1] = carry;
            if (this.negative) {
                negative = true;
            }
        } else if (this.negative != addend.negative && addend.negative) {      
            BFInt result = this.minus(addend.abs());
            return result;
        } else if (this.negative != addend.negative && this.negative) {
            BFInt result = this.abs().minus(addend);
            result.negative = true;
            return result;
        }

        BFInt newSum = new BFInt();
        newSum.digits = sum;
        newSum.negative = negative;

        return new BFInt(newSum);
    }

    private static byte[] pad(byte[] digits, int numZeros) {
        byte[] digitsLength = new byte[digits.length + numZeros];
        for (int i = 0; i < digits.length; i++) {
            digitsLength[i] = digits[i]; 
        }
        for (int i = digits.length; i < digits.length + numZeros; i++) {
            digitsLength[i] = 0;
        }
        return digitsLength;
    }

    /**
    * Returns the difference of this BFInt minus the given subtrahend.
    */
    public BFInt minus(BFInt subtrahend) {
        // TODO: Finish me, pretty please.

        byte[] sub = new byte[this.digits.length + 1]; 
        byte[] longer = null;
        byte[] shorter = null;
        boolean negative = false;
        byte carry = 0;

        if (this.negative == subtrahend.negative && !this.negative && subtrahend.isGreaterThan(this)) {
            if (subtrahend.digits.length > this.digits.length) {
                this.digits = pad(this.digits, subtrahend.digits.length - this.digits.length);
                sub = new byte[this.digits.length + 1];
            }
            for (int i = 0; i < subtrahend.digits.length; i++) {
                if (carry > 0) {
                    subtrahend.digits[i] -= 1;
                    carry = 0;
                }
                if (subtrahend.digits[i] >= this.digits[i]) {
                    sub[i] = (byte) (subtrahend.digits[i] - this.digits[i]);
                    
                } else if (subtrahend.digits[i] < this.digits[i]) {
                    sub[i] = (byte) (10 + subtrahend.digits[i] - this.digits[i]);
                    carry = 1;                    
                }
            }
            negative = true;   
        } else if (this.negative == subtrahend.negative && !this.negative && this.isGreaterThan(subtrahend)) {
            if (this.digits.length > subtrahend.digits.length) {
                subtrahend.digits = pad(subtrahend.digits, this.digits.length - subtrahend.digits.length);
            }
            for (int i = 0; i < this.digits.length; i++) {
                if (carry > 0) {
                    this.digits[i] -= 1;
                    carry = 0;
                }
                if (this.digits[i] >= subtrahend.digits[i]) {
                    sub[i] = (byte) (this.digits[i] - subtrahend.digits[i]);
                } else if (!(this.digits[i] >= subtrahend.digits[i])) {
                    sub[i] = (byte) (10 + this.digits[i] - subtrahend.digits[i]);
                    carry = 1;
                } 
            }
        } else if (this.negative != subtrahend.negative && subtrahend.negative) {
            BFInt result = this.plus(subtrahend.abs());
            return result;
        } else if (this.negative == subtrahend.negative && this.negative && subtrahend.isLessThan(this)) {
            if (subtrahend.digits.length > this.digits.length) {
                this.digits = pad(this.digits, subtrahend.digits.length - this.digits.length);
            }
            for (int i = 0; i < subtrahend.digits.length; i++) {
                if (carry > 0) {
                    subtrahend.digits[i] -= 1;
                    carry = 0;
                }
                if (subtrahend.digits[i] >= this.digits[i]) {
                    sub[i] = (byte) (subtrahend.digits[i] - this.digits[i]);
                } else if (subtrahend.digits[i] < this.digits[i]) {
                    sub[i] = (byte) (10 + subtrahend.digits[i] - this.digits[i]);
                    carry = 1;
                }
            }
            negative = false;
        } else if (this.negative == subtrahend.negative && this.negative && this.isLessThan(subtrahend)) {
            if (this.digits.length > subtrahend.digits.length) {
                subtrahend.digits = pad(subtrahend.digits, this.digits.length - subtrahend.digits.length);
            }
            for (int i = 0; i < subtrahend.digits.length; i++) {
                if (carry > 0) {
                    this.digits[i] -= 1;
                    carry = 0;
                }
                if (this.digits[i] >= subtrahend.digits[i]) {
                    sub[i] = (byte) (this.digits[i] - subtrahend.digits[i]);
                } else if (!(this.digits[i] >= subtrahend.digits[i])) {
                    sub[i] = (byte) (10 + this.digits[i] - subtrahend.digits[i]);
                    carry = 1;
                }
            }
            negative = true;
        }
        else if (this.negative != subtrahend.negative && this.negative) {
            BFInt result = this.abs().plus(subtrahend);
            result.negative = true;
            return result;
        }  
                   
        BFInt newSub = new BFInt();
        newSub.digits = sub;
        newSub.negative = negative;      
        return new BFInt(newSub);
    }

    public BFInt divideByTwo() {
        byte result[] = new byte[this.digits.length];
        String answer = "";
        for (int i = 0; i < this.digits.length - 1; i++) {
            if (this.digits[i + 1] % 2 == 0) {
                result[i] = (byte) (this.digits[i] / 2);
            } else {
                result[i] = (byte) ((this.digits[i] / 2) + 5);
                this.digits[i + 1]--;
            }
        }
        result[this.digits.length - 1] = (byte) (this.digits[this.digits.length - 1] / 2);
        for (int i = result.length - 1; i >= 0; i--) {
            answer += result[i];
        }
        return new BFInt(answer);
    }

    /**
    * Returns the product of this BFInt times the given multiplier.
    */
    public BFInt times(BFInt multiplier) {
        BFInt left = new BFInt(this.toString());
        boolean neg = false;

        if ((left.negative && !(multiplier.negative))) {
            left.negative = false;
            neg = true;
        } 
        if (!(left.negative) && multiplier.negative) {
            multiplier.negative = false;
            neg = true;
        }
        
        if (multiplier.negative && left.negative) {
            multiplier.negative = false;
            left.negative = false;
            neg = false;
        } 
        if (left.isEqualTo(ZERO) || multiplier.isEqualTo(ZERO)) {
            neg = false;
        }

        
        BFInt product = new BFInt();
        while (left.isGreaterThan(ONE) || left.isEqualTo(ONE)) {
            if (left.digits[0] % 2 != 0) {
                product = product.plus(multiplier);
            }
            left = left.divideByTwo();
            multiplier = multiplier.plus(multiplier);
        }
        product.negative = neg;
        return product;
    }

    /**
    * Returns the quotient of this BFInt divided by the given divisor.
    * Throws an IllegalArgumentException if the divisor is 0.
    */
    public BFInt dividedBy(BFInt divisor) {
        // TODO: Finish me, pretty please.
        boolean neg = false;
        
        if ((this.negative && !divisor.negative) || (!this.negative && divisor.negative)) {
            neg = true;
        } else if ((this.negative && divisor.negative) || (!this.negative && !divisor.negative)) {
            neg = false;
        }

        if (divisor.isEqualTo(ZERO)) {
            throw new IllegalArgumentException();
        } else if (this.abs().isLessThan(divisor) || (this.isLessThan(divisor.abs()) && divisor.negative 
                && !this.negative)) {
            return ZERO;
        } else if (this.isEqualTo(divisor) && this.negative || (this.isEqualTo(divisor) && !this.negative)) {
            return ONE;
        } else if (this.abs().isEqualTo(divisor) && this.negative || this.isEqualTo(divisor.abs()) && divisor.negative) {
            return NEGATIVE_ONE;
        } else if (divisor.isEqualTo(ONE)) {
            return this;
        } else if (divisor.isEqualTo(NEGATIVE_ONE)) {
            this.negative = true;
            return this;
        }

        BFInt partialQuotient = new BFInt(ONE);
        BFInt finalQuotient = new BFInt(ZERO);
        BFInt subtract = new BFInt(divisor.toString());

        while ((subtract.abs().times(new BFInt(TEN))).isLessThan(this.abs())) {
            subtract = subtract.abs().times(new BFInt(TEN));
            partialQuotient = partialQuotient.times(new BFInt(TEN));
        }
        finalQuotient = partialQuotient.plus((this.abs().minus(subtract.abs()).dividedBy(divisor.abs())));
        finalQuotient.negative = neg;

        return finalQuotient;
    }

    /**
     * Returns the remainder of this BFInt divided by the given divisor.
     * Throws an IllegalArgumentException if the divisor is 0.
     */
    public BFInt mod(BFInt divisor) {
        // TODO: Finish me, pretty please.
        boolean neg = false;

        if ((this.negative && !(divisor.negative)) || (this.negative && divisor.negative)) {
            neg = true;
        } else {
            neg = false;
        }
        return (this.minus((this.dividedBy(divisor)).times(divisor)));
    }

    @Override
    public String toString() {
        // TODO: Finish me, pretty please.
        String result = negative ? "-" : "";
        for (int i = digits.length - 1; i >= 0; i--) {
            result += digits[i];
        }
        return result;
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Please enter two numbers");
            return;
        } else {
            BFInt first = new BFInt(args[0]);
            BFInt second = new BFInt(args[1]);

            System.out.println("Sum: " + first.plus(second));
            System.out.println("Difference: " + first.minus(second));
            System.out.println("Product: " + first.times(second));
            System.out.println("Quotient: " + first.dividedBy(second));
            System.out.println("Remainder: " + first.mod(second));
        }

        
    }


    // This is advanced java down here...you don't need to worry about these.

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        return isEqualTo((BFInt)obj);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(digits);
        result = prime * result + (negative ? 0 : 1);
        return result;
    }

}
