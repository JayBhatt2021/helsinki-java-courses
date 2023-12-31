import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> productPriceMap;
    private Map<String, Integer> productStockMap;

    public Warehouse() {
        this.productPriceMap = new HashMap<>();
        this.productStockMap = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.productPriceMap.put(product, price);
        this.productStockMap.put(product, stock);
    }

    public int price(String product) {
        if (this.productPriceMap.containsKey(product)) {
            return this.productPriceMap.get(product);
        }

        return -99;
    }

    public int stock(String product) {
        if (this.productStockMap.containsKey(product)) {
            return this.productStockMap.get(product);
        }

        return 0;
    }

    public boolean take(String product) {
        if (this.productStockMap.containsKey(product) && this.productStockMap.get(product) > 0) {
            this.productStockMap.put(product, this.productStockMap.get(product) - 1);
            return true;
        }

        return false;
    }

    public Set<String> products() {
        return this.productPriceMap.keySet();
    }
}
