/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author JayBh
 */
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
