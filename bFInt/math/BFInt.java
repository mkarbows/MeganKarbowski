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
    public static final BFInt ZERO = null;
    /**
    * A constant for a BFInt with a value of -1.
    */
    public static final BFInt NEGATIVE_ONE = null;
    /**
    * A constant for a BFInt with a value of 1.
    */
    public static final BFInt ONE = null;
    /**
    * A constant for a BFInt with a value of 10.
    */
    public static final BFInt TEN = null;

    // These are the private instance variables for BFInt. You can change these if you
    // have a different idea for how to represent a BFInt object.
    private boolean negative;
    private byte[] digits;

    public BFInt() {
        // TODO: Finish me, pretty please.
    }

    public BFInt(int number) {
        // TODO: Finish me, pretty please.
    }

    public BFInt(long number) {
        // TODO: Finish me, pretty please.
    }

    public BFInt(short number) {
        // TODO: Finish me, pretty please.
    }

    public BFInt(byte number) {
        // TODO: Finish me, pretty please.
    }

    public BFInt(BFInt bFInt) {
        // TODO: Finish me, pretty please.
    }

    public BFInt(String numberString) {
        // TODO: Finish me, pretty please.
    }

    public boolean isEqualTo(BFInt other) {
        // TODO: Finish me, pretty please.
        return false;
    }

    public boolean isGreaterThan(BFInt other) {
        // TODO: Finish me, pretty please.
        return false;
    }

    public boolean isLessThan(BFInt other) {
        // TODO: Finish me, pretty please.
        return false;
    }

    /**
     * Returns true if the this BFInt is negative.
     */
     public boolean isNegative() {
         return false;
     }

    /**
     * Returns a new BFInt that is the absoulte value of this BFInt.
     */
    public BFInt abs() {
        // TODO: Finish me, pretty please.
        return null;
    }

    // TODO: Add missing methods that are in the specs here.

    /**
    * Returns the sum of this BFInt plus the addend.
    */
    public BFInt plus(BFInt addend) {
        // TODO: Finish me, pretty please.
        return null;
    }

    /**
    * Returns the difference of this BFInt minus the given subtrahend.
    */
    public BFInt minus(BFInt subtrahend) {
        // TODO: Finish me, pretty please.
        return null;
    }

    /**
    * Returns the product of this BFInt times the given multiplier.
    */
    public BFInt times(BFInt multiplier) {
        // TODO: Finish me, pretty please.
        return null;
    }

    /**
    * Returns the quotient of this BFInt divided by the given divisor.
    * Throws an IllegalArgumentException if the divisor is 0.
    */
    public BFInt dividedBy(BFInt divisor) {
        // TODO: Finish me, pretty please.
        return null;
    }

    /**
     * Returns the remainder of this BFInt divided by the given divisor.
     * Throws an IllegalArgumentException if the divisor is 0.
     */
    public BFInt mod(BFInt divisor) {
        // TODO: Finish me, pretty please.
        return null;
    }

    @Override
    public String toString() {
        // TODO: Finish me, pretty please.
        return "";
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
