/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
public class Bot extends Player {
    @Override
    public void play() {
        System.out.print("The Bot ");
        super.printName();
        System.out.println(" plays!");
    }
    
    public void addMove(String move) {
        System.out.println("The Bot " + move);
    }
}
