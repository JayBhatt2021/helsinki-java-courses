/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> dict;
    
    public IOU() {
        this.dict = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        this.dict.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return this.dict.getOrDefault(toWhom, 0.0);
    }
}
