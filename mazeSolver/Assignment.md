# Maze Solver
## Due 05/08/2015

For the final assignment, we'll be making use of the backtracking paradigm. Backtracking involves
building a solution, and rather than abandoning the entire solution when it becomes invalid, we jump
back (backtrack) to the last fork in the decision making and choosing a different path.

To make use of the backtracking paradigm, you're tasked with coding up an algorithm to lead a mouse
through a maze to a block of cheese. The algorithm looks like this:

* If the mouse is on the cheese, we're found it.
* Otherwise, pick a direction (up, left, down, right)
* If the direction is legal (no wall) and we haven't been there yet, go in that direction. Leave a
bread crumb to mark that we've been there.
* If it's not legal or we've already been there, try again with a different direction.
* If you've tried every direction, backtrack (go the opposite of the last direction).
* Repeat until the cheese is found, or we've determined it's impossible. It's impossible
if we're back where we started, and we've already been in every legal direction.

The good news is that a lot of the code has been written for you. All of the graphics,
the maze class, and various other classes are completed. The only file you're required to
change is MazeWalker.java, which contains the backtracking logic.

### MazeWalker

The MazeWalker class contains the logic for walking a mouse through a maze and finding the cheese (or
determining if it's impossible to get there). Here are the methods you'll need to complete.

* **public MazeWalker(Maze maze, int cheeseX, int cheeseY):** The sole MazeWalker constructor. Given
the maze object and the cheese's x and y coordinates, initializes the MazeWalker. This includes
initializing any instance variables you'll need.
* **public WalkerState areWeThereYet(int currentX, int currentY):** This is where the crux of the
backtracking logic exists. Given the current x and y value of the mouse, it returns a WalkerState enum:
*ALREADY_THERE* if we found the cheese, *IMPOSSIBLE_TO_GET_THERE* if it's impossible, or the next direction
the mouse should go. The loop that calls this method for each cell has already been created for you inside
another class, so you only have to return the logic per cell.
* **public boolean[][] getBreadCrumbs():** Returns the bread crumbs, or in other words, returns a 2D table
of booleans for each cell. The boolean is true if we've already been to that cell. Note that the width should
be first and the height seconds, so that getting a bread crumb at a given coordinate (x, y) would be
called like this:  
```java
boolean breadCrumb = this.breadCrumbs[x][y];
```

* **public PathStack getCurrentPath():** Returns the PathStack object that contains the
directions taken by the MazeWalker.

### PathStack

PathStack is a nested class inside MazeWalker whose sole purpose is to keep track of the
directions taken by the mouse to the current point.

* **public PathStack(int maxCapacity):** Constructs a new PathStack object with the given maximum capacity.
* **public WalkerState pushDirection(WalkerState direction):** Pushes (adds) a new direction to the
top of the stack and returns that direction.
* **public WalkerState popDirection():** Pops (removes) the direciton on the top of the stack and returns
it. Throws an IllegalArgumentException if the stack is empty.
* **public boolean isEmpty():** Returns true if the stack has no directions.
* **public WalkerState[] toArray():** Returns an array representing the PathStack. Removes any null
values if necessary.

### Running Maze Solver

Maze Solver has a more complex structure than any of the other assignments.
If you don't know how to use git on the command line, instead of copy/pasting
each of the many files into the proper directories, you can download the base code
from the [course web site.](http://my.cs.lmu.edu/~akhayat/files/mazeSolver.zip)

Here are some notes on how to run it.

* All javac and java commands should be called inside the src/main/java directory, so
make sure you cd to that directory before running the program.
* The main method lies in edu/lmu/cs/maze/app/GUISolver.java. To compile the class,
use this command:  
*javac edu/lmu/cs/maze/app/GUISolver.java*
Since GUISolver relies on all the other classes, you only need to compile GUISolver.java
to compile the entire project.

* To run the project, use this command:  
*java edu.lmu.cs.maze.app.GUISolver \<mouse x\> \<mouse y\> \<cheese x\> \<cheese y\> [ \<time interval\> ]*  
where time interval is the amount of time between each mouse movement in milliseconds. Time interval
is optional, and the default is a 500 millisecond (1/2 second) pause between moves.

* After running GUISolver, the user will then be prompted for input. The input should be
 the maze the user wishes to test the algorithm in. Construct the maze using the **'-'**
 character to represent open spaces and the **'\#'** character to represent walls.
 The maze must be rectangular. For example, to create a simple 3x3 mazes,
 you would enter this:

#

    -##  
    -#-  
    ---  

Press **ctrl+d** when you're finished. This will launch the GUISolver with the given
maze.

* Alternatively, instead of typing out a new maze every time you wish to run the app, you
can give it a preexisting maze. To do that run it like this:  
*java edu.lmu.cs.maze.app.GUISolver \<mouse x\> \<mouse y\> \<cheese x\> \<cheese y\> [ \<time interval\> ]
< path/to/text/file*  
Some mazes have been provided for you in the maze directory.

* As an example, if I wanted to run the app with the mouse at (0, 0), the cheese at (2, 7), the time
interval at 200 milliseconds, and the maze as the sample.txt maze in the mazes folder,
I'd run it like this:  
*java edu.lmu.cs.maze.app.GUISolver 0 0 2 7 200 < ../../../mazes/sample.txt*

### Extra Credit

There are two opportunities for extra credit in this project. The normal backtracking
algorithm only requires that you use a set order of directions to test for before
moving the mouse. This isn't the only way to choose a direction for the mouse.
For extra credit, you may implement the two alternate methods.

To show the proper radio buttons, uncomment lines 90-92 in
*edu/lmu/cs/maze/app/gui/MouseAndCheeseMazeView.java.*

```java
// mouseStyleGroup.add((JRadioButton)b.add(normal));
// mouseStyleGroup.add((JRadioButton)b.add(smart));
// mouseStyleGroup.add((JRadioButton)b.add(random));
```

#### SmartMazeWalker

 The first alternative MazeWalker is the "smart" walker. For the "smart" algorithm,
 the mouse smells the cheese and bases its direction order on its location. For example,
 if the cheese is mostly above the mouse and slightly to the right, the it will
 try the directions in this order: UP, RIGHT, LEFT, then DOWN. If the cheese is
 mostly to the left and slightly downward, the mouse will choose this order:
 LEFT, DOWN, UP, then RIGHT. In the case of a tie between the vertical and horizontal
 distance, either direction is acceptable.

#### RandomMazeWalker

The second is relatively straightforward. Every time the mouse moves, the priority
of directions is completely random. Note that this doesn't mean that it always goes
in a random direction. It means the order in which it checks each direction is random.
For example, he might check if LEFT is a valid cell, and if it's not, it might then check,
UP then RIGHT then DOWN.

To implement these, two MazeWalker subclasses have been created for you:
SmartMazeWalker and RandomMazeWalker. Your job is to override the necessary method(s)
to alter the priority of directions the mouse checks. You may want to read up on
[subclasses in java.](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)

### General Notes for the Project

* **DON'T FORGET TO COMMIT AT THE END OF CLASS (or at least, at the end of the day in which we had class).**
You're also encouraged to commit after every milestone (finish a method, class, stubs, etc.).
* For this assignment, you cannot use any classes from the java collections library.
* Even though MazeWalker is the only class you need to touch, you will be using
edu.lmu.cs.maze.model.Maze.java in your solution, so it might be useful to look at that
class.
* In Swing (and most graphics libraries), the coordinate system works differently than
 the standard 2D Cartesian coordinate system. The origin (0, 0) lies at the top *left*
 of the window. Then the y-axis is inverted so that positive y values are below the x-axis.
 Here's an example given the sample.txt maze

#

    (0,0)-#-#------(9,0)
         -###---##-
         -#------#-
         -#--------
         -#-######-
         -#--------
         -########-
         -#--------
         -########-
    (0,9)----------(9,9)
