package clock;

/**
 * Represents an object whose sole purpose is to find the times when a
 * given angle is made by the hour and minute hand of the clock (within a margin
 * of error equal to half the grain of the Clock).
 */
public class ClockSolver {

    // TODO: Add instance variables/constants here.
    private Clock clock;
    private double angleBetween;
    private double goalAngle;
    private double currentAngle;

    /**
     * Constructs a ClockSolver Object with the given angle to find and
     * passes the DEFAULT_GRAIN to the Clock constructor.
     */
    public ClockSolver(double angleToFind) {
        // TODO: Finish this constructor.
        this(angleToFind, 1.0);

        
    }
    public ClockSolver(double angleToFind, double grain) {
        clock = new Clock(12, 0, 0, grain);
        goalAngle = angleToFind;
        angleBetween = 0;
        if (angleToFind < 0 || grain <= 0.0) {
            throw new IllegalArgumentException();
        }
    }
    public String getClockTime() {
        return this.clock.toString();
    }
    public double getSecondsPassed() {
        return this.clock.getSecondsPassed();
    }
    public double getAngleBetween() {
        return angleBetween; 
    }
    public void tickClock() {
        clock.tick();
        angleBetween = (angleBetween + (this.clock.getGrain()*(5.5/60))) % 360;
    }
    public boolean foundAngle() {
        return (angleBetween >= this.goalAngle - ((5.5/60)*this.clock.getGrain()) && 
            angleBetween < this.goalAngle + ((5.5/60)*this.clock.getGrain())) ||
            (360 - angleBetween >= this.goalAngle - ((5.5/60)*this.clock.getGrain()) &&
            360 - angleBetween < this.goalAngle - ((5.5/60)*this.clock.getGrain()));
    }

    // TODO: Add other constructor and methods.

    public static void main(String[] args) {
        // TODO: Print some stuff here.
    }

}
