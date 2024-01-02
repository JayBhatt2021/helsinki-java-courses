public class StandardSensor implements Sensor {
    private int sensorNumber;

    public StandardSensor(int sensorNumber) {
        this.sensorNumber = sensorNumber;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {

    }

    @Override
    public void setOff() {

    }

    @Override
    public int read() {
        return this.sensorNumber;
    }
}
