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
public class Hold {
    private int maxWeight;
    private ArrayList<Suitcase> hold;
    
    public Hold(int maxWeight) {
        this.maxWeight = maxWeight;
        this.hold = new ArrayList<>();
    }
    
    public int tot() {
        int tot = 0;
        for (Suitcase s : this.hold) {
            tot += s.totalWeight();
        }
        return tot;
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if (suitcase.totalWeight() + this.tot() <= this.maxWeight) {
            this.hold.add(suitcase);
        }
    }
    
    @Override
    public String toString() {
        return this.hold.size() + " suitcases (" + this.tot() + " kg)";
    }
    
    public void printItems() {
        for (Suitcase s : this.hold) {
            s.printItems();
        }
    }
}
