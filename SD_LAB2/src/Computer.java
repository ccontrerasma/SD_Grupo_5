
public class Computer {
    private double clockTime;

    public Computer(double initialTime) {
        this.clockTime = initialTime;
    }

    public double getClockTime() {
        return clockTime;
    }

    public void setClockTime(double time) {
        this.clockTime = time;
    }
}
