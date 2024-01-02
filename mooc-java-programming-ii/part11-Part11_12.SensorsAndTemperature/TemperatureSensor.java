import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean sensorState;

    public TemperatureSensor() {
        this.sensorState = false;
    }

    @Override
    public boolean isOn() {
        return this.sensorState;
    }

    @Override
    public void setOn() {
        this.sensorState = true;
    }

    @Override
    public void setOff() {
        this.sensorState = false;
    }

    @Override
    public int read() {
        return new Random().nextInt(61) - 30;
    }
}
