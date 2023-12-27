/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
public class Person implements Saveable {
    private String name;
    private String address;
    
    @Override
    public void save() {
        this.name = "John Doe";
        this.address = "123 Mary Lane";
    }
    
    @Override
    public void delete() {
        this.address = "";
    }
    
    @Override
    public void load(String address) {
        this.address = address;
    }
}
