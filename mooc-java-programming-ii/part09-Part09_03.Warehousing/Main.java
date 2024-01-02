public class Main {
    public static void main(String[] args) {
        ProductWarehouseWithHistory p = new ProductWarehouseWithHistory("Console", 200.0, 200.0);

        p.takeFromWarehouse(18.0);
        p.addToWarehouse(12.0);
        p.printAnalysis();
    }
}
