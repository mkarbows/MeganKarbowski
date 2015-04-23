package edu.lmu.cs.maze.app;

import edu.lmu.cs.maze.model.Maze;
import edu.lmu.cs.maze.model.Maze.Location;

/**
 * MazeWalker is the object that is responsible for staking out a path down some
 * maze. Given a 2D array of maze cells and a starting location, it calculates
 * the next "legal" move such that the walker can eventually cover every square
 * in the maze that is reachable from that starting location.
 *
 * @author dondi
 */
public class MazeWalker {
    /**
     * The possible states of the current "walk" through a maze.
     */
    public enum WalkerState {
        /**
         * Indicates that the maze walker has reached its assigned destination.
         */
        THERE_ALREADY,

        /**
         * Indicates that the maze walker has concluded that it is impossible to
         * reach its destination.
         */
        IMPOSSIBLE_TO_GET_THERE,

        /**
         * Indicates that the maze walker would like to move left.
         */
        MOVE_LEFT,

        /**
         * Indicates that the maze walker would like to move up.
         */
        MOVE_UP,

        /**
         * Indicates that the maze walker would like to move right.
         */
        MOVE_RIGHT,

        /**
         * Indicates that the maze walker would like to move down.
         */
        MOVE_DOWN
    }

    /**
     * Initializes the MazeWalker, providing it with the maze to use and the
     * walker's destination.
     */
    public MazeWalker(Maze maze, int cheeseX, int cheeseY) {
        // TODO: Implement me!
    }

    /**
     * Takes a step toward reaching the given destination from the given current
     * location, and returns either the direction of the next step, whether or
     * not that destination has been reached, or whether that destination is
     * impossible to reach.
     */
    public WalkerState areWeThereYet(int currentX, int currentY) {
        // TODO: Implement me!
        return WalkerState.IMPOSSIBLE_TO_GET_THERE;
    }

    /**
     * Returns a representation of the locations which the walker has visited.
     * The 2D array's dimensions should correspond to those of the walker's
     * assigned maze.
     */
    public boolean[][] getBreadCrumbs() {
        // TODO: Implement me!
        return new boolean[0][0];
    }

    /**
     * Returns the current path taken by the walker.
     */
    public PathStack getCurrentPath() {
        //TODO: Implement me!
        return new PathStack(0);
    }

    /**
     * A Stack-like object for keeping track of the directions the mouse has
     * traveled to reach the current location.
     */
    public class PathStack {

        /**
         * Creates a new PathStack object with the given
         * Maximum capacity.
         */
        public PathStack(int maxCapacity) {
            // TODO: Implement me!
        }

        /**
         * Adds a new direction to the the top of the PathStack and
         * returns the direction.
         */
        public WalkerState pushDirection(WalkerState direction) {
            // TODO: Implement me!
            return null;
        }

        /**
         * Removes the direction on the top of the stack and returns it.
         * If the stack is empty, throws an IllegalArgumentException.
         */
        public WalkerState popDirection() {
            // TODO: Implement me!
            return null;
        }

        /**
         * Returns true of the PathStack has no directions.
         */
        public boolean isEmpty() {
            // TODO: Implement me!
            return false;
        }

        /**
         * Returns an array of the directions taken by the mouse, removing any
         * null values if necessary.
         */
        public WalkerState[] toArray() {
            // TODO: Implement me!
            return new WalkerState[0];
        }
    }
}
