public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory hist;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);

        hist = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.hist.add(this.getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double taken = super.takeFromWarehouse(amount);
        this.hist.add(this.getBalance());
        return taken;
    }

    public String history() {
        return this.hist.toString();
    }

    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.hist.maxValue());
        System.out.println("Smallest amount of product: " + this.hist.minValue());
        System.out.println("Average: " + this.hist.average());
    }
}
