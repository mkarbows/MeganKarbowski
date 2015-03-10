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
    private double secondsPassed = 0.0;

    public Clock() {
        // TODO: Finish this and the other constructors.
        this(12, 0, 0.0, 1.0);
    }
    public Clock(int hours) {
        this(hours, 0, 0.0, 1.0);
    }
    public Clock(int hours, int minutes) {
        this(hours, minutes, 0.0, 1.0);
    }
    public Clock(int hours, int minutes, double seconds) {
        this(hours, minutes, seconds, 1.0);
    }
    public Clock(int hours, int minutes, double seconds, double grain) {
        if ((hours >= 1 || hours <= 12) && (minutes >= 0 || minutes <= 60) && (seconds >= 0.0 || seconds <= 60.0) && (grain > 0.0)) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            this.grain = grain;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public int getHours() {
        return this.hours;
    }
    public int getMinutes() {
        return this.minutes;    
    }
    public double getSeconds() {
        return this.seconds;
    }
    public double getGrain() {
        return this.grain;
    }
    public double getSecondsPassed() {
        return this.secondsPassed;
    }
    public void tick() {
        seconds += grain;
        secondsPassed += grain;
        minutes += this.seconds / 60;
        System.out.println(minutes);
        seconds = this.seconds % 60;
        hours = (hours + (minutes / 60)) % 12;
        minutes = this.minutes % 60;
        if (this.hours == 0) {
            this.hours = 12;
        }
    }

    // TODO: Add missing methods and constructors.

    @Override
    public String toString() {
        // TODO: Finish this method.
        if (getHours() < 10) {
            String hours = "0" + getHours();
        } else {
            String hours = "" + getHours();
        }
        if (getMinutes() < 10) {
            String minutes = "0" + getMinutes();
        } else {
            String minutes = "" + getMinutes();
        }
        if (getSeconds() < 10) {
            String seconds = "0" + getSeconds();
        } else {
            String seconds = "" + getSeconds();
        }
        return hours + ":" + minutes + ":" + seconds;
    }
}
