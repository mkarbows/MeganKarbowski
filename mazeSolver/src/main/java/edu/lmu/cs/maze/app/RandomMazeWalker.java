package edu.lmu.cs.maze.app;

import edu.lmu.cs.maze.model.Maze;

/**
 * A version of the MazeWalker class that chooses the order of directions to
 * check randomly.
 */
public class RandomMazeWalker extends MazeWalker {

    public RandomMazeWalker(Maze maze, int destinationX, int destinationY) {
        super(maze, destinationX, destinationY);
    }

}
