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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> sensorReadings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.sensorReadings = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    @Override
    public boolean isOn() {
        boolean allSensorsOn = true;
        for (Sensor s : this.sensors) {
            if (!s.isOn()) {
                allSensorsOn = false;
                break;
            }
        }
        return allSensorsOn;
    }
    
    @Override
    public void setOn() {
        this.sensors.forEach(s -> {
            s.setOn();
        });
    }
    
    @Override
    public void setOff() {
        this.sensors.forEach(s -> {
            s.setOff();
        });
    }
    
    @Override
    public int read() {
        if (!this.isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException("AverageSensor must be on and have at least one sensor.");
        }
        
        int sum = 0;
        sum = this.sensors.stream()
                .map(s -> s.read())
                .reduce(sum, Integer::sum);
        
        int average = sum / this.sensors.size();
        this.sensorReadings.add(average);
        return average;
    }
    
    public List<Integer> readings() {
        return this.sensorReadings;
    }
}
