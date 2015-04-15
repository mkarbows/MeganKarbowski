# Change Maker Redux
## Due 04/23/2015

Back to basics...well, sort of. You're going to be writing a Change Maker program
again—but with a twist. This time, instead of using the standard American
25¢, 10¢, 5¢, and 1¢ coins, the denominations of the coins will be arbitrary. For example,
suppose we live in an alternate universe, where 9¢, 4¢, and 1¢ coins are used instead of the
usual. Note that if you want to make 12¢ with these coins, there are two possibilities:
one 9¢ coin and three 1¢ coins **or** three 4¢ coins. Note that the second answer is slightly
more efficient, using 3 coins instead of 4. Our goal is, **given a number of cents,
discover the most efficient way to make that number with given denomination of coins.**

### DynamicChangeMaker

We'll be using the dynamic programming paradigm to code up the solution for our little
dilemma. Dynammic programming involves breaking up a problem into similar subproblems.
First, you find the solution to each number of cents less than the number of cents you want,
using only the first denomination. Then you do the same with the first *and* second
denomination. Then the third, etc., etc. You then store each solution in a table of tuples.
The solution tuple in the last row and last column is the solution to the whole problem.

Here's the summary of the algorithm:

Is the amount > current denomination?  
**yes:**
* Get the difference
* Add the a new coin.
* Is it better?  
**no:**
* Use old (or null if old does not exist).

You only have to implement one method:

* **public static IntTuple makeChange(IntTuple denominations, int cents):** Returns
an IntTuple containing the most efficient number of cents for each denomination that
makes up the total number of cents. Returns null if it's impossible to find a solution.

### DynamicChangeMakerTest

Straightforward enough. Creates a few tests for the makeChange method. Stubs and
a single test case have been provided for you.

* **private static void test_makeChange():** The test method. Need I say more?

### General Notes for the Project

* **DON'T FORGET TO COMMIT AT THE END OF CLASS (or at least, at the end of the day in which we had class).**
You're also encouraged to commit after every milestone (finish a method, class, stubs, etc.).
* The IntTuple class, and its useful methods (intAt, set, equals, copy, sumOfElements, plus)
have been provided for you. You can refer to the IntTuple.java file that's included.
* The solution involves creating a table of IntTuples. To create a table in java, you can create
an array of arrays. The syntax looks like this:
```java
IntTuple[][] changeTable = new IntTuple[numberOfRows][numberOfColumns];
```
* The main method and all the input checking has also been done for you. You'll notice I made use
of the cents(¢) character by inserting **\u00a2** in some of the message strings. The windows command
line doesn't handle unicode characters properly, so if you're using windows, you'll have to replace
**\u00a2** with the 'c' character (or something similar).
* Here's an example of a solution table that would be generated if the desired cents is 8 and the coin
denominations are 1,4,5. The answer is the final cell: 1¢: 0, 4¢: 2, 5¢: 0.

|           | 0         | 1         | 2         | 3         | 4         | 5         | 6         | 7         | 8         |
|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|
| <1>       | <0, 0, 0> | <1, 0, 0> | <2, 0, 0> | <3, 0, 0> | <4, 0, 0> | <5, 0, 0> | <6, 0, 0> | <7, 0, 0> | <8, 0, 0> |
| <1, 4>    | <0, 0, 0> | <1, 0, 0> | <2, 0, 0> | <3, 0, 0> | <0, 1, 0> | <1, 1, 0> | <2, 1, 0> | <3, 1, 0> | <0, 2, 0> |
| <1, 4, 5> | <0, 0, 0> | <1, 0, 0> | <2, 0, 0> | <3, 0, 0> | <0, 1, 0> | <0, 0, 1> | <1, 0, 1> | <2, 0, 1> | <0, 2, 0> |

* Here's an example of a solution table that would be generated if the desired cents is 14 and the coin
denominations are 10,1,4. The answer is the final cell: 10¢: 0, 1¢: 0, 7¢: 2

|            | 0         | 1         | 2         | 3         | 4         | 5         | 6         | 7         | 8         | 9         | 10        | 11        | 12        | 13        | 14        |
|------------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|
| <10>       | <0, 0, 0> | -         | -         | -         | -         | -         | -         | -         | -         | -         | <1, 0, 0> | -         | -         | -         | -         |
| <10, 1>    | <0, 0, 0> | <0, 1, 0> | <0, 2, 0> | <0, 3, 0> | <0, 4, 0> | <0, 5, 0> | <0, 6, 0> | <0, 7, 0> | <0, 8, 0> | <0, 9, 0> | <1, 0, 0> | <1, 1, 0> | <1, 2, 0> | <1, 3, 0> | <1, 4, 0> |
| <10, 1, 7> | <0, 0, 0> | <1, 0, 0> | <0, 2, 0> | <0, 3, 0> | <0, 4, 0> | <0, 5, 0> | <0, 6, 0> | <0, 0, 1> | <0, 1, 1> | <0, 1, 2> | <1, 0, 0> | <1, 1, 0> | <1, 2, 0> | <1, 3, 0> | <0, 0, 2> |
