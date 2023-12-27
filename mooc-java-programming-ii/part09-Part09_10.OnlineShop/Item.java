/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
public class Item {
    private String product;
    private int qty;
    private int unitPrice;
    
    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    
    public String getProductName() {
        return this.product;
    }
    
    public int getQuantity() {
        return this.qty;
    }

    public int price() {
        return this.qty * this.unitPrice;
    }
    
    public void increaseQuantity() {
        this.qty++;
    }
    
    @Override
    public boolean equals(Object comparedObject) {
        // if the variables are located in the same place, they're the same
        if (this == comparedObject) {
            return true;
        }

        // if comparedObject is not of type Item, the objects aren't the same
        if (!(comparedObject instanceof Item)) {
            return false;
        }

        Item comparedItem = (Item) comparedObject;

        // if the instance variables of the objects are the same, so are the objects
        if (this.product.equals(comparedItem.product) &&
            this.qty == comparedItem.qty &&
            this.unitPrice == comparedItem.unitPrice) {
            return true;
        }

        // otherwise, the objects aren't the same
        return false;
    }

    @Override
    public String toString() {
        return this.product + ": " + this.qty;
    }
}
