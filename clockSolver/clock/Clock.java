package clock;

/**
 * Represents a standard twelve-hour analog clock, keeping track of the hours,
 * minutes, and seconds of the hands. Clock also has a grain. The grain is the
 * number of seconds the clock moves each time the tick() method is called.
 */
public class Clock {

    // TODO: Add instance variables/constants here.
    private int hours;
    private int minutes;
    private double seconds;
    private double grain;

    public Clock() {
        // TODO: Finish this and the other constructors.
        this(12, 0, 0, 1.0);
    }
    public Clock(int hours) {
        this(hours, 0, 0, 1.0);
    }
    public Clock(int hours, int minutes) {
        this(hours, minutes, 0, 0.1);
    }
    public Clock(int hours, int minutes, double seconds) {
        this(hours, minutes, seconds, 1.0);
    }
    public Clock(int hours, int minutes, double seconds, double grain) {
        if ((hours >= 1 || hours <= 12) && (minutes >= 0 || minutes <= 60) && (seconds >= 0 || seconds <= 60) && (grain > 0)) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            this.grain = grain;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public int getHours() {
        return -1;
    }
    public int getMinutes() {
        return -1;
    }
    public double getSeconds() {
        return -1;
    }
    public double getGrain() {
        return -1;
    }
    public double getSecondsPassed() {
        return -1;
    }
    public void tick() {

    }


    // TODO: Add missing methods and constructors.

    @Override
    public String toString() {
        // TODO: Finish this method.
        return "";
    }

}
