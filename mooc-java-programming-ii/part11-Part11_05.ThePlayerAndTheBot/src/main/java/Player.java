/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
public class Player {
    private String name;
    
    public void play() {
        System.out.println("The player " + this.name + " plays!");
    }
    
    public void printName() {
        System.out.print(this.name);
    }
}
