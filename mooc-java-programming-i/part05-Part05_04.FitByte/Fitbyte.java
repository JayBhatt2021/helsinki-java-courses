public class Fitbyte {
    private int age;
    private int restingHeartRate;

    public Fitbyte(int age, int restingHeartRate) {
        this.age = age;
        this.restingHeartRate = restingHeartRate;
    }

    public double targetHeartRate(double percentageOfMaximum) {
        double maxHeartRate = 206.3 - (0.711 * this.age);
        return (maxHeartRate - this.restingHeartRate) * percentageOfMaximum + this.restingHeartRate;
    }
}
