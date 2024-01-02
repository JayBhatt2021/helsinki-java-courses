import java.util.ArrayList;

public class Suitcase {
    private int maximumWeight;
    private ArrayList<Item> items;

    public Suitcase(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (this.totalWeight() + item.getWeight() <= this.maximumWeight) {
            this.items.add(item);
        }
    }

    public int totalWeight() {
        int totalWeight = this.items.stream()
                .mapToInt(item -> item.getWeight())
                .reduce(0, (previousTotalWeight, itemWeight) ->
                        previousTotalWeight + itemWeight
                );

        return totalWeight;
    }

    public void printItems() {
        this.items.stream()
                .forEach(item -> System.out.println(item));
    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }

        return this.items.stream()
                .max((i1, i2) -> i1.getWeight() - i2.getWeight())
                .get();
    }

    @Override
    public String toString() {
        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (this.items.size() == 1) {
            return "1 item (" + this.totalWeight() + " kg)";
        }

        return this.items.size() + " items (" + this.totalWeight() + " kg)";
    }
}
