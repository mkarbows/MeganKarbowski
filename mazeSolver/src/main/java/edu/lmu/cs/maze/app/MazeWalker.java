package edu.lmu.cs.maze.app;

import edu.lmu.cs.maze.model.Maze;
import edu.lmu.cs.maze.model.Maze.Location;
import java.util.Arrays;

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

    private Maze maze;
    private int cheeseX;
    private int cheeseY;
    private boolean[][] breadCrumbs;
    private PathStack pathStack;
    
    /**
     * Initializes the MazeWalker, providing it with the maze to use and the
     * walker's destination.
     */
    public MazeWalker(Maze maze, int cheeseX, int cheeseY) {
        this.maze = maze;
        this.cheeseX = cheeseX;
        this.cheeseY = cheeseY;
        this.pathStack = new PathStack(maze.getMazeWidth() * maze.getMazeHeight());
        this.breadCrumbs = new boolean[maze.getMazeWidth()][maze.getMazeHeight()];
    }

    public static WalkerState oppositeDirection(WalkerState top) {
        switch (top) {
            case MOVE_UP: return WalkerState.MOVE_DOWN;
            case MOVE_DOWN: return WalkerState.MOVE_UP;
            case MOVE_LEFT: return WalkerState.MOVE_RIGHT;
            case MOVE_RIGHT: return WalkerState.MOVE_LEFT;
            default: throw new IllegalArgumentException("Can't reverse this direction");
        }
    }

    /**
     * Takes a step toward reaching the given destination from the given current
     * location, and returns either the direction of the next step, whether or
     * not that destination has been reached, or whether that destination is
     * impossible to reach.
     */
    public WalkerState areWeThereYet(int currentX, int currentY) {
        breadCrumbs[currentX][currentY] = true;
        if (currentX == this.cheeseX && currentY == this.cheeseY) {
            return WalkerState.THERE_ALREADY;      
        } else if (this.maze.getLocation(currentX, currentY).getAbove().isOpen() &&
            !this.breadCrumbs[currentX][currentY - 1]) {
            return this.pathStack.pushDirection(WalkerState.MOVE_UP);
        } else if (this.maze.getLocation(currentX, currentY).getLeft().isOpen() &&
            !this.breadCrumbs[currentX - 1][currentY]) {
            return this.pathStack.pushDirection(WalkerState.MOVE_LEFT);
        } else if (this.maze.getLocation(currentX, currentY).getBelow().isOpen() &&
            !this.breadCrumbs[currentX][currentY + 1]) {
            return this.pathStack.pushDirection(WalkerState.MOVE_DOWN);
        } else if (this.maze.getLocation(currentX, currentY).getRight().isOpen() &&
            !this.breadCrumbs[currentX + 1][currentY]) {
            return this.pathStack.pushDirection(WalkerState.MOVE_RIGHT);
        } else if (this.pathStack.isEmpty()) {
            return WalkerState.IMPOSSIBLE_TO_GET_THERE;
        }        
        return oppositeDirection(this.pathStack.popDirection());
    }

    /**
     * Returns a representation of the locations which the walker has visited.
     * The 2D array's dimensions should correspond to those of the walker's
     * assigned maze.
     */
    public boolean[][] getBreadCrumbs() {
        return this.breadCrumbs;
    }

    /**
     * Returns the current path taken by the walker.
     */
    public PathStack getCurrentPath() {
        return this.pathStack;
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
        private int topOfStack;
        public PathStack(int maxCapacity) {
            // TODO: Implement me!
            this.stack = new WalkerState[maxCapacity];
            this.topOfStack = -1;
        }

        /**
         * Adds a new direction to the the top of the PathStack and
         * returns the direction.
         */
        private WalkerState[] stack;
        public WalkerState pushDirection(WalkerState direction) {
            topOfStack++;
            stack[topOfStack] = direction;    
            return direction;
        }

        /**
         * Removes the direction on the top of the stack and returns it.
         * If the stack is empty, throws an IllegalArgumentException.
         */
        public WalkerState popDirection() {
            if (this.isEmpty()) {
                throw new IllegalArgumentException("Stack is empty");
            }
            WalkerState topDirection = stack[topOfStack];
            topOfStack--;
            return topDirection;
        }

        /**
         * Returns true of the PathStack has no directions.
         */
        public boolean isEmpty() {
            return topOfStack == -1;
        }

        /**
         * Returns an array of the directions taken by the mouse, removing any
         * null values if necessary.
         */
        public WalkerState[] toArray() {
            WalkerState[] newStack = new WalkerState[topOfStack + 1];
            for (int i = 0; i <= topOfStack; i++) {
                newStack[i] = stack[i];
            }
            return newStack;
        }
    }
}
