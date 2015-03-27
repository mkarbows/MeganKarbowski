# BFInt
## Due 03/26/2015

Tired of your calculus class? Linear algebra getting you down? Let's jump back to basic arithmetic.

If you look up the Integer.MAX_INT value in java, you'll notice it isn't terribly high (2^31 - 1 or 2147483648).
Okay, that's kind of high, but Bill Gates probably has more than that in his bank account. We're going to
solve this problem by making our own BigInteger class that deals with arbitrarily large numbers. This means creating
functions such as plus, minus, times, and dividedBy *from scratch.*

The good news is that you already have a detailed knowledge of algorithms that accomplish these things.

The bad news is that it's **a lot** more difficult to put these in java terms than you'd think.
Seriously—this assignment's a doozy.

Along with the time-honored methods for multiplying and dividing that you probably learned in elementary school,
we'll also be going over two alternative methods (Russian Peasant Multiplication and Decrease and Conquer)
that you might find easier to program.

One last note: **You cannot use java's built in BigInteger class or Arrays.copyOf method (and its relatives)
for this assignment.**

Now on to to specifications for the code.

### BFInt

The 'B' stands for big.

For this assignment, you'll be creating a java Object that represents an arbitrarliy large integer
(Max value has around Integer.MAX_INT (~2 billion) *digits*). In the stub, you'll notice
two instances variables have been given for you: A byte array called digits and a boolean called negative.
While I recommend representing your BFInt this way, feel free to change that representation to fit your style,
as long as the methods work.

Here are the constatns associated with BFInt. You  might find them to be useful in your big four methods.

* **public static final BFInt ZERO:** Constant representing a BFInt with a value of 0.
* **public static final BFInt NEGATIVE_ONE:** Constant representing a BFInt with a value of -1.
* **public static final BFInt ONE:** Constant representing a BFInt with a value of 1.
* **public static final BFInt TEN:** Constant representing a BFInt with a value of 10.

Here are all the constructors for BFInt. Since there are so many, I'd reccomend chaining them
with the "this" keyword. [Here's](http://stackoverflow.com/questions/285177/how-do-i-call-one-constructor-from-another-in-java)
a Stack Overflow article explaining how to do that.

* **public BFInt():** Constructs a new BFInt object with a value of 0.
* **public BFInt(int number):** Constructs a new BFInt object with the same value as the given int.
* **public BFInt(long number):** Constructs a new BFInt object with the same value as the given long.
* **public BFInt(short number):** Constructs a new BFInt object with the same value as the given short.
* **public BFInt(byte number):** Constructs a new BFInt object with the same value as the given byte.
* **public BFInt(BFInt bFInt):** Constructs a new BFInt object which is a **copy** of the given BFInt.
* **public BFInt(String numberString):** This constructor will have to do the heavy lifting.
Constructs a new BFInt object taking its digits from the given String. The String should be in the format
"[s]ddddd..." Where s is optional and is either the '+' character or '-' character (indicating positive or negative),
If there is no sign, it assumes the number is positive. The d's are digits from 0-9. If this constructor encounters anything
that isn't a digit from 0-9 or, in the case of the first character, a + or - sign, then it should
throw an IllegalArgumentException.

So that's how you create a BFInt object. Now what can you do with them? These are the methods you will be creating.
Notice that a lot of the methods build off of each other, so I recommend writing them in the order they appear.

The big four methods here (i.e. where the points are thickest) are plus, minus, times, and dividedBy (also, isEqualTo, isGreaterThan, and isLessThan
are important, too). The other methods are mostly just to help with those big ones.

Also note that BFInts should be immutable, meaning that the value of a BFInt does not change. Each of these methods
returns a new BFInt object.

* **public boolean isEqualTo(BFInt other):** Returns true if this BFInt has the same value as the other
(in other words, has the same magnitude and sign).
* **public boolean isGreaterThan(BFInt other):** Returns true if this BFInt is greater than the given BFInt.
* **public boolean isLessThan(BFInt other):** Returns true if this BFInt is less than the given BFInt.
**Hint, hint:** In other words, returns true if this BFInt is not greater than and  not equal to the other.
* **public boolean isGreaterThanOrEqualTo(BFInt other):** Returns true if this BFInt is greater than or equal to the other.
* **public boolean isLessThanOrEqualTo(BFInt other):** Discards all input and prints an ASCII drawing of a robot.
* **public boolean isNegative():** Returns true if the BFInt is negative.
* **public boolean isEven():** Returns true if the BFInt is even.
* **public boolean isOdd():** Pretty much what you'd expect.
* **public BFInt abs():** Returns a new BFInt that is the absolute value of this BFInt. In other words,
the same magnitude but not negative.
* **public String toString():** Returns the String representation of this BFInt. There shouldn't be any leading zeros.


**THE BIG ONES**

* **public BFInt plus(BFInt addend):** Returns the sum of this BFInt and the addend.
* **public BFInt minus(BFInt subtrahend):** Returns the difference of this BFInt and the subtrahend.
* **public BFInt times(BFInt multiplier):** Returns the product of this BFInt and the multiplier.
* **public BFInt dividedBy(BFInt divisor):** Returns the quotient of this BFInt and the divisor.
Should throw an IllegalArgumentException if the divisor is zero.

Slightly important but not as important:

* **public BFInt mod(BFInt divisor):** Returns the remainder of this BFInt dividedBy the divisor.
Should throw an IllegalArgumentException if the divisor is zero.

Main should be pretty low-key for this assignment.

* **public static void main(String[] args):** Prints out the sum, difference, product, quotient, and remainder of args[0] and args[1].
As always, you should output messages if either String is not a number or there aren't at least two arguments (or
if the second number is zero, since you can't divide by zero).

### Fibonacci and/or Factorial and/or GCD and/or Exponent

When you've completed BFInt, to demonstrate it, you'll want to write at
least two of the following applications (**extra credit if you write all four**):

* An Exponent class that raises some BFInt (including
    negative numbers) to some non-negative
    BFInt power (including zero).

    *java math.Exponent -3428347589 1001*

* A Factorial class that calculates the factorial of
    any non-negative BFInt.

    *java math.Factorial 234918230*

* A Fibonacci class that takes a natural number n
    and calculates the nth number in the Fibonacci
    sequence (0, 1, 1, 2, 3, 5, 8…).

    *java math.Fibonacci 10000*

* A GCD class that finds the greatest common divisor
    of two arbitrarily large positive integers.

    *java math.GCD 123594857495687676666745857293509351 1234456797957795749373967798797979743*

### General Notes for the Project

* **DON'T FORGET TO COMMIT AT THE END OF CLASS (or at least, at the end of the day in which we had class).**
    You're also encouraged to commit after every milestone (finish a method, class, stubs, etc.).
* A lot of array manipulations will happen, like adding digits to the beginning or end or
    removing leading zeros. Sometimes you might repeat these manipulations, so it's a good idea to make private static methods to do these for you.
    In fact, it's probably a good idea to refresh your array knowledge while you're at it. You can read the Java Tutorial
    on them [here.](http://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
* Again, you can't use Arrays.copyOf or BigInteger.
* You might find it's easier to store your digits in reverse order. In other words, the first digit of
    the array is the *last* digit of the number. It's ultimately up to you, however.
* Because of the difficulty of the assignment, a test class will be provided for you.
