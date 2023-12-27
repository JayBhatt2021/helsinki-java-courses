/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        this.history.clear();
    }
    
    public double maxValue() {
        if (this.history.isEmpty()) {
            return 0.0;
        }
        
        double maxValue = Double.MIN_VALUE;
        for (double element : this.history) {
            if (maxValue < element) {
                maxValue = element;
            }
        }
        return maxValue;
    }
    
    public double minValue() {
        if (this.history.isEmpty()) {
            return 0.0;
        }
        
        double minValue = Double.MAX_VALUE;
        for (double element : this.history) {
            if (minValue > element) {
                minValue = element;
            }
        }
        return minValue;
    }
    
    public double average() {
        if (this.history.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (double element : this.history) {
            sum += element;
        }
        return sum / this.history.size();
    }
    
    @Override
    public String toString() {
        return this.history.toString();
    }
}
