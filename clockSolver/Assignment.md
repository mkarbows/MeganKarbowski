# Clock Solver
## Due 03/12/2015

This program is an implementation of the Discrete Event Simulation paradigm. What the
hell does that mean, you ask? It means you'll be solving a problem by created an
environment and advancing the state by a certain amount of time called the grain.
Each time you advance the state, you'll then check if you have a solution.

For this project specifically, we'll be working with clocks. Given an angle in degrees, you'll be writing a
program to print out the time (hours, minutes, and seconds) in which the hour and minute hand
of a twelve-hour analog clock (the one with the hands. They still have those, right?).

While this could be solved algebraically, we're interested in a more programmatic approach.
We're going to simulate a clock object, make it tick, then check to
see if hands form the angle we want. We'll then tick the clock until the hands come back
to the beginning, and print out every time we get that matches the given angle.

That's the general description of what we're doing. Let's talk about the actual classes
we're going to be making.

### Clock

The clock class is pretty much what you'd expect. It represents an twelve-hour analog
clock that has hours, minutes, seconds and a grain. The grain is the amount of time (in seconds)
that the clock should jump for each tick.

* **public Clock():** Constructs a Clock starting at 12:00:00.0 with a grain of 1.0 seconds.
* **public Clock(int hours):** Constrcuts a Clock at the given hour at 0 minutes and 0.0 seconds
        and a grain of 1.0 seconds.
* **public Clock(int hours, int minutes):** Constructs a Clock at the given hour and minute
        with 0.0 seconds and a grain of 1.0 seconds.
* **public Clock(int hours, int minutes, double seconds):** Constructs an hour with the given hour, minute,
        and seconds and a grain of 1.0 seconds.
* **public Clock(int hours, int minutes, double seconds, double grain):** Constructs a Clock with
        the given hour, minutes, seconds, and grian. Throws an IllegalArgumentException if one the
        the following is true: Hours isn't between 1 and 12, minutes isn't between 0 and 60, seconds isn't
        between 0 and 60, grain isn't greater than 0.
* **public int getHours():** Returns where the hour hand is on the clock.
* **public int getMinutes():** Returns where the minute hand is on the clock.
* **public double getSeconds():** Returns where the second hand is on the clock.
* **public double getGrain():** Returns what the grain is for this clock.
* **public double getSecondsPassed():** Returns the amount of time has been ticked away
        for this clock (in seconds).
* **public void tick():** Bumps the time up on the clock by an amount of seconds equal
        to the grain. Takes care of reseting the seconds, minutes, and hours values if they
        creep past their maximum values.
* **public String toString():** Returns a String representation of the clock. So basically,
        it returns the time as a String such as "12:00:00.0" or "05:36:54.9" (notice the leading
        zeros).

### ClockSolver

ClockSolver is an Object that, given an angle, will construct a clock, tick it, and determine
whether or not the given angle is made by the hour and minute hand of the clock.

* **public ClockSolver(double angleToFind):** Constructs a ClockSolver Object with the given
        angle to search for. Creates a clock (starting at 12:00:00.0) with a default grain of 1.0 second.
* **public ClockSolver(double angleToFind, double grain):** Constructs a ClockSolver Object
        with the given angle to search for and creates a clock starting at 12:00:00.0 with
        the given grain. Throws an IllegalArgumentException if the grain is <= 0.0 or the
        angleToFind < 0.0.
* **public String getClockTime():** Returns a String representation of the current time on the clock.
* **public double getSecondsPassed():** Returns the number of seconds that have elapsed on the Solver's internal clock.
* **public double getAngleBetween():** Returns the current angle between the hour and minute hands
        of the Clock Object.
* **public void tickClock():** Ticks the clock and updates the angle between the hands.
* **public boolean foundAngle():** Returns true if the current angle between the hands is
        within the margin of error of the angle the solver is looking for. Note that we don't
        care about the orientation of the angle. In other words, the result, for example, should
        be the same for 90 degrees and 270 degrees.
* **public static void main(String[] args):** Parses args[0] into an angle, and optionally
        parses args[1] into a grain. It then constructs a ClockSolver object, ticks the clock
        for an entire revolution (twelve hours) and prints out the time whenever
        foundAngle is true, or in other words, whenever the angle between the hands is within the
        appropriate margin of error of the given angle. There should be some error checking done here:  

* If no arguments are entered, the program should output:  
    * *Usage: java clock.ClockSolver \<angleToFind> [ \<grain> ]* (or something similar) and exit.
* If the given angle is not a number, the program should output:
    * *Given angle is not a valid number.* (or something similar) and exit.
* If the angle is negative, the program should output:
    * *Angle must be >= 0.* (or something similar) and exit.
* If the angle is greater or equal to 360, the program should convert it to an angle less than 360
        and continue running normally.
* If the grain is not supplied, the program should use a default of 1.0s and continue running normally.
* If the grain is not a number, the program should output:
    * *Grain not a number. Using default: 1.0s* (or something similar) and **continue running**
        with a default grain of 1.0s.
* If the grain is 0 or less, the program should output:
    * *Grain must be > 0.0. Using default: 1.0s* (or something similar) and **continue running**
        with a default grain of 1.0s.
* If the grain is greater than 1800.0, the program should output:
    * *Grain must be <= 1800.0s. Using default: 1.0s* (or something similar) and **continue running**
        with a default grain of 1.0s.
* If the program is still running at this point, it should construct a ClockSolver Object with
        the parsed angle and grain, loop until twelve hours have passed on the ClockSolver's clock, and after each tick,
        it should print out the time if the angle was found.

### ClockTest

Part of this assignment is learning how to create your own automated unit tests.
This time around, instead of me writing tests for you to use, you will be creating your own.
The test file (ClockTest.java) has been stubbed out for you. You must complete the
following methods inside it:

* **private static void test_clockConstructors():** Tests to see if the clock constructors
        are working properly. In other words, test to see if hours, minutes, seconds, grain, and
        secondsPassed are getting initialized properly. Also check to make sure
        an IllegalArgumentException is being thrown when input is invalid.
* **private static void test_tick():** Test the tick method. Make sure that hours, minutes,
        seconds, and secondsPassed fields are all being incremented properly when the
        clock ticks. This includes testing that seconds and minutes reset after 60
        and hours resets after 12.
* **private static void test_clockSolverConstructors():** Tests to make sure that the
        ClockSolver object is being constructed properly. This means ensuring the clock
        is being initialized properly, the grain, and also the angleToFind and angleBetween,
        and that an IllegalArgumentException is being thrown when the angleToFind and grain
        are invalid.
* **private static void test_foundAngle():** Tests that foundAngle returns true when the
        angleToFind is within the proper margin of error, and that it returns false when it isn't.

### General Notes for the Project

* **DON'T FORGET TO COMMIT AT THE END OF CLASS (or at least, at the end of the day in which we had class).**
You're also encouraged to commit after every milestone (finish a method, class, stubs, etc.).
* Assume all angles are in degrees.
* Make sure your code simulates the a clock ticking and doesn't just find the answer algebraically.
* Add descriptions for your methods in comments (look at the given code from videoPoker for
a better idea on how to do that).
* This program involves a lot of constants. I'd recommend storing them in variables marked
*private static final* in order to cut down on hard coding.
