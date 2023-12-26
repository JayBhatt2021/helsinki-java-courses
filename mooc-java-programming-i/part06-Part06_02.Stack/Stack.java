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

public class Stack {
    private ArrayList<String> stack;
    
    public Stack() {
        this.stack = new ArrayList<String>();
    }
    
    public boolean isEmpty() {
        return this.stack.size() == 0;
    }
    
    public void add(String value) { 
        this.stack.add(value);
    }
    
    public ArrayList<String> values() {
        return this.stack;
    }
    
    public String take() {
        String top = this.stack.remove(this.stack.size() - 1);
        return top;
    }
}