public class Human implements Comparable<Human> {
    private int wage;
    private String name;

    public Human(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public int getWage() {
        return wage;
    }
    
    // Promotes descending sorts
    @Override
    public int compareTo(Human comparedHuman) {
        return comparedHuman.getWage() - this.wage;
    }

    @Override
    public String toString() {
        return name + " " + wage;
    }
}
