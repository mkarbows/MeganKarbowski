# Monte Carlo Methods
## Due 04/14/2015

Tired of your calculus class? Well, that's unfortunate for you because...

For this project, we'll be using the Monte Carlo (or Randomized Estimation) paradigm, specifically
we'll be using it to estimate the value of pi and also, estimate definite integrals as an alternative
approach to Riemann sums. The algorithm involves
inscribing the slice of the function in a rectangle, picking random points inside of it,
and adding up the ones under the curve. Then, you use the ratio of hits to total random points
to determine the ratio of the area of the curve to the area of the rectangle.

For a more in-depth explanation, you can read about
[Monte Carlo Integration](http://en.wikipedia.org/wiki/Monte_Carlo_integration) here.

On to the specs...

### Pistimator

For this class, you'll be creating a Pistimator object who's sole purpose is to estimate pi
by inscribing the unit circle inside of a square of side length 2. A given number of "darts"
(points) will then be thrown randomly at the square. It then uses the ratio of hits inside the circle
to total darts thrown to estimate pi.

Here are the constructors for Pistimator:

* **public Pistimator():** Constructs a Pistimator object with a default of 100000 darts to be thrown.
* **public Pistimator(long darts):** Constructs a Pistimator object with the given number of darts.

And the methods:

* **public double estimatePi():** Estimates pi using the method described above.
* **public long getHits()**: Returns the number of hits from the last estimate.
* **public static void main(String[] args):** Creates a Pistimator object and prints out the number of hits,
number of darts, and estimation of pi. The program should use either args[0] darts or a default of 100000 darts
if args[0] isn't provied or is malformed.

### MonteCarloIntegrator

A class for estimating the area under the curve of a given function using Monte Carlo Integration. In other words, the object
estimates the definite integral by inscribing a rectangle around the domain and range of the function, then throwing darts
inside the rectangle, and using the ratio of hits to total darts to find the area under the curve. Note that
hits that are negative should be subtracted from hits that are positive, rather than added.

Only one constructor required for this one.

* **public MonteCarloIntegrator(Integratable function):** Constructs a MonteCarloIntegrator object with the given function.

And the methods:

* **public double integrate(double lowerBound, double upperBound):** Returns the definite integral on the given bounds using the
Monte Carlo method with a default of 1000000 darts.
* **public double integrate(double lowerBound, double upperBound, long darts):** Returns the definite integral on the given bounds using the
Monte Carlo method with the given bounds and number of darts. If the lower bound is smaller than the upper bound, the two
should either be swapped or an exception should be thrown. Up to you.
* **public static void main(String[] args):** Uses the given arguments to construct a polynomial to integrate on a given lower and upper bounds.
    * *args[0]:* should be the number of darts.
    * *args[1]:* should be the lower bound.
    * *args[2]:* should be the upper bound.
    * *args[3]+:* should be the coefficients of the polynomial. The exponent should be determined by the index. For example:
        * *java math.MonteCarloIntegrator 100000 -1.5 3.1 2 0 -3.55 5*
    should integrate the polynomial f(x) = 2x^3 - 3.55x + 5 on the domain [-1.5, 3.1] using 100000 darts.
        * *java math.MonteCarloIntegrator 1000 0 10 -2*
    should integrate the polynomial f(x) = -2 on the domain [0, 10] using 1000 darts.
    * If there aren't at least 3 arguments, or the arguments aren't valid numbers, the program should quit
    and the user should be notified.

### Polynomial

A class that represents a polynomial function. Implements the Integratable interface.

The constructors:

* **public Polynomial():** Constructs a polynomial f(x) = 1.0.
* **public Polynoomial(double[] coefficients):** Constructs a polynomial with the given coefficients.

And the sole required method:

* **public double f(double x):** Computes value of f(x) for this polynomial.

### PolynomialTest

A test class for the MonteCarlo project.

The only test method is:

* **public static void test_polynomial():** Should construct some polynomials,
plug in various values for x, and test the result.

Even though only one test is required, you may write tests for other classes/methods if you want.

### Extra Credit

There are three opportunites for extra credit.

* The minimum requirement for the assignment is to integrate a given polynomial. However, for extra credit, you may add functionality
for different type of function. To do that, create a new class that implements Integratable. Some examples of functions you can do are
sin(x), cos(x), ln(x), 2^x, x*sin(x). Two things to mention here. You should be able to handle coefficients. For example, sin(x) might be
in the form -5sin(2x - 1) + 5. The second thing is you will have to alter the main method of MonteCarloIntegrator to handle the new function.
You'd have to run it like this: *java math.MonteCarloIntegrator -5.0 4.4 poly 1.0 -12.3 6* to integrate the polynomial x^2 - 12.3x + 6 on [-5, 4.4]
and like this: *java math.MonteCarloIntegrator 5 10 exp2 5 4 -2 1 to integrate 5 * 2^(4x - 2) + 4 on [5, 10].

* The second opportunity is to create another class called RiemannIntegrator. It should have similar methods to MonteCarloIntegrator, but
it should calculate the area under the curve using Riemann sums. Left, midpoint, or right is completely up to you. If you do this, don't
copy the main method in both class, but rather, have one main method in a third class, and create both a MonteCarloIntegrator and a RiemannIntegrator,
and compare the output of the two integration styles on the same function.

* The last opportunity for extra credit is to create a toString in polynomial that outputs the polynomial in a pretty format. For example,
if the coefficients of your polynomial are [-3, -4.5, 0, 1.01, -1, 5], the String representation of the polynomial should be:
*"f(x) = -3x^5 - 4.5x^4 + 1.01x^2 - x + 5"*. Some notes here:
    * If the decimal is also an integer, you should chop of the ".0". For example, show 3 instead of 3.0
    * If the coefficient is negative, subtract the term (unless it's the first term, then attach the negative sign to the coefficient).
    * if the coefficient is 0, do not print the term at all.
    * If the power is 1, don't print the power (i.e x^1 should just say x).
    * If the power is 0, don't print x at all.
    * There should be spaces before and after terms (except before the first and after the last).
    * Use the toString inside your MonteCarloIntegrator's main method. Print out the function before you print out the area under the curve.
    * This one's harder than it sounds. I suggest writing tests to verify correctness.

### Dartboard

A visualization class has been provided for you: Dartboard.java. Both MonteCarlo and Pistimator can use this class
to print out a quick graph of where the darts landed. Running the graphical aid is not required for the assignment,
but might help you visualize it better.

To use this program with Pistimator, modify your program to print out each x and y coordinate of each dart
whether it's in the circle or not. The method to print this line is included in the stub.
Sample output for your *java math.Pistimator 4* would be:

    start
    0.9749404511152815 -0.6292054434468402 out
    -0.24866749230116936 0.6995132510143782 in
    0.38795945930283704 -0.47382662713513524 in
    0.1316693603871264 -0.07696092016831191 in
    end
    Hits = 3
    Darts thrown = 4
    π ~ 3.0


You then run the Dartboard by piping the output of MonteCarloIntegrator to Dartboard.
For example, you'd run it like this:

    java math.Pistimator 100000 | java math.Dartboard

Instructions for running it with MonteCarloIntegrator coming soon!

### General Notes for the Project

* **DON'T FORGET TO COMMIT AT THE END OF CLASS (or at least, at the end of the day in which we had class).**
You're also encouraged to commit after every milestone (finish a method, class, stubs, etc.).
* No tests for integrate are explicitly required, but you may write them if you want to. Even if you don't
automate your testing, it's a good idea to  compare your results to
[Wolfram Alpha's integral calculator.](http://www.wolframalpha.com/input/?i=definite+integral)
* This assignment involves a lot of math, obviously, so be sure to keep an eye out for useful built-in java math functions. You can
see them all [here.](http://docs.oracle.com/javase/7/docs/api/java/lang/Math.html)
* Although minor, this project does involve some inheritence, specifically interfaces. You can read up on interfaces in java
[here.](http://docs.oracle.com/javase/tutorial/java/concepts/interface.html)
