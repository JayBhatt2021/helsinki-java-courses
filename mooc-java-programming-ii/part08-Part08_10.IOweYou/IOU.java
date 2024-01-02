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
