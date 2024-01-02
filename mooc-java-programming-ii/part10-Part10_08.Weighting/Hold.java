import java.util.ArrayList;

public class Hold {
    private ArrayList<Suitcase> suitcases;
    private int maximumWeight;

    public Hold(int maximumWeight) {
        this.suitcases = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.totalWeight() + suitcase.totalWeight() <= maximumWeight) {
            this.suitcases.add(suitcase);
        }
    }

    public int totalWeight() {
        int totalWeight = this.suitcases.stream()
                .mapToInt(suitcase -> suitcase.totalWeight())
                .reduce(0, (previousTotalWeight, suitcaseWeight) ->
                        previousTotalWeight + suitcaseWeight
                );

        return totalWeight;
    }

    public void printItems() {
        this.suitcases.stream()
                .forEach(suitcase -> suitcase.printItems());
    }

    @Override
    public String toString() {
        if (this.suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        }

        if (this.suitcases.size() == 1) {
            return "1 suitcase (" + this.totalWeight() + " kg)";
        }

        return this.suitcases.size() + " suitcases (" + this.totalWeight() + " kg)";
    }
}
