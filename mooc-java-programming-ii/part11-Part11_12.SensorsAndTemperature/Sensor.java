public interface Sensor {
    // returns true if the sensor is on
    boolean isOn();

    // sets the sensor on
    void setOn();

    // sets the sensor off
    void setOff();

    // returns the value of the sensor if it's on
    // if the sensor is not on throw a IllegalStateException
    int read();
}
