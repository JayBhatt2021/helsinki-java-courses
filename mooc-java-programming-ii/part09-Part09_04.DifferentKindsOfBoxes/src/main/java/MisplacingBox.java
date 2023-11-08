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

public class MisplacingBox extends Box {
    private ArrayList<Item> items;
    
    public MisplacingBox() {
        this.items = new ArrayList<>();
    }
    
    @Override
    public void add(Item item) {
        this.items.add(item);
    }
    
    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}
