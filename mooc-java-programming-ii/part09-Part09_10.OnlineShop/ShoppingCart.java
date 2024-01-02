import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private List<Item> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void add(String product, int price) {
        int quantity = 1;
        for (Item item : this.cart) {
            if (product.equals(item.getProductName())) {
                quantity = item.getQuantity();
            }
        }

        Item item = new Item(product, quantity, price);
        if (this.cart.contains(item)) {
            this.cart.remove(item);
            item.increaseQuantity();
        }

        this.cart.add(item);
    }

    public int price() {
        int sumPrice = 0;
        for (Item item : this.cart) {
            sumPrice += item.price();
        }

        return sumPrice;
    }

    public void print() {
        for (Item item : this.cart) {
            System.out.println(item);
        }
    }
}
