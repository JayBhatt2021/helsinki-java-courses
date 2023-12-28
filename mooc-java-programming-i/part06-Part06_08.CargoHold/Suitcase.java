import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Item> items;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public int totalWeight() {
        int weightSum = 0;
        for (Item i : this.items) {
            weightSum += i.getWeight();
        }
        return weightSum;
    }

    public void addItem(Item item) {
        if (item.getWeight() + this.totalWeight() <= this.maxWeight) {
            this.items.add(item);
        }
    }

    @Override
    public String toString() {
        int itemCount = this.items.size();
        switch (itemCount) {
            case 0:
                return "no items (" + this.totalWeight() + " kg)";
            case 1:
                return "1 item (" + this.totalWeight() + " kg)";
            default:
                return itemCount + " items (" + this.totalWeight() + " kg)";
        }
    }

    public void printItems() {
        for (Item i : this.items) {
            System.out.println(i.getName() + "(" + i.getWeight() + " kg)");
        }
    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }

        Item heaviest = this.items.get(0);
        for (int i = 1; i < this.items.size(); i++) {
            Item item = this.items.get(i);

            if (item.getWeight() > heaviest.getWeight()) {
                heaviest = item;
            }
        }

        return heaviest;
    }
}
