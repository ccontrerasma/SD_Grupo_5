
public class ReferenceServer {
    private double referenceTime;

    public ReferenceServer(double initialTime) {
        this.referenceTime = initialTime;
    }

    public double getReferenceTime() {
        return referenceTime;
    }

    public void synchronize(double newTime) {
        this.referenceTime = newTime;
    }
}
