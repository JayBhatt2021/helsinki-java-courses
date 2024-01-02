import java.util.ArrayList;

public class Box implements Packable {
    private double maximumCapacity;
    private ArrayList<Packable> packableList;

    public Box(double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.packableList = new ArrayList<>();
    }

    public void add(Packable pack) {
        if (this.weight() + pack.weight() <= this.maximumCapacity) {
            this.packableList.add(pack);
        }
    }

    @Override
    public double weight() {
        double totalWeight = 0;
        for (Packable pack : this.packableList) {
            totalWeight += pack.weight();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Box: " + this.packableList.size() + " items, total weight " + this.weight() + " kg";
    }
}
