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
        if (angleToFind < 0 || grain <= 0.0 || grain > 1800) {
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
        return (angleBetween >= this.goalAngle - ((5.5/60)*this.clock.getGrain()/2) && 
            angleBetween < this.goalAngle + ((5.5/60)*this.clock.getGrain()/2)) ||
            (360 - angleBetween >= this.goalAngle - ((5.5/60)*this.clock.getGrain()/2) &&
            360 - angleBetween < this.goalAngle + ((5.5/60)*this.clock.getGrain()/2));
    }
    // TODO: Add other constructor and methods.

    public static void main(String[] args) {
        // TODO: Print some stuff here.
        if (args.length == 0 || args.length > 2) {
            System.out.println("Usage: java clock.ClockSolver <angleToFind> <grain(optional)>");
            return;
        }
        double angleToFind = -1;
        double grain = 1.0;
        try {
            angleToFind = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Given angle is not a valid number");
            return;
        }
        if (angleToFind < 0) {
            System.out.println("Angle must be >= 0");
            return;
        }
        if (angleToFind > 360) {
            angleToFind %= 360;
        }

        try { 
            if (args.length == 2) {
               grain = Double.parseDouble(args[1]); 
            } 
        } catch (NumberFormatException e) {
                System.out.println("Grain not a number. Using default: 1.0s");
        }
        if (grain <= 0) {
            System.out.println("Grain must be > 0.0. Using default: 1.0s");
        }
        if (grain > 1800.0) {
            System.out.println("Grain must be <= 1800.0s. Using default: 1.0s");
        }

        ClockSolver finalClock = new ClockSolver(angleToFind, grain);
        //for (int i = 0; i < )
    }
}
