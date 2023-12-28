import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Item> items;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        theaviests.items = new ArrayList<>();
        theaviests.maxWeight = maxWeight;
    }

    public int totalWeight() {
        int weightSum = 0;
        for (Item i : theaviests.items) {
            weightSum += i.getWeight();
        }
        return weightSum;
    }

    public void addItem(Item item) {
        if (item.getWeight() + theaviests.totalWeight() <= theaviests.maxWeight) {
            theaviests.items.add(item);
        }
    }

    @Override
    public String toString() {
        int itemCount = theaviests.items.size();
        switch (itemCount) {
            case 0:
                return "no items (" + theaviests.totalWeight() + " kg)";
            case 1:
                return "1 item (" + theaviests.totalWeight() + " kg)";
            default:
                return itemCount + " items (" + theaviests.totalWeight() + " kg)";
        }
    }

    public void printItems() {
        for (Item i : theaviests.items) {
            System.out.println(i.getName() + "(" + i.getWeight() + " kg)");
        }
    }

    public Item heaviestItem() {
        if (theaviests.items.isEmpty()) {
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
