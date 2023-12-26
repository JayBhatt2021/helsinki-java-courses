/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
public class Product {
    private double price;
    private int quantity;
    private String name;
    
    public Product (String initialName, double initialPrice, int initialQuantity) {
        this.price = initialPrice;
        this.name = initialName;
        this.quantity = initialQuantity;
    }
    
    public void printProduct() {
        System.out.println(this.name + ", price " + this.price + ", " + this.quantity + " pcs");
    }
}
