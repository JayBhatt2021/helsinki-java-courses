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

public class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> items;
    
    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    
    @Override
    public void add(Item item) {
        int totalWeightSoFar = 0;
        for (Item i : this.items) {
            totalWeightSoFar += i.getWeight();
        }
        if (totalWeightSoFar + item.getWeight() <= capacity) {
            this.items.add(item);
        }
    }
    
    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}
