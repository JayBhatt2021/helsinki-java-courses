import java.util.ArrayList;

public class SimpleCollection {
    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    @Override
    public String toString() {
        if (this.elements.isEmpty()) {
            return "The collection " + this.name + " is empty.";
        }

        String s = "The collection " + this.name + " has " + this.elements.size();
        if (this.elements.size() == 1) {
            s += " element:\n" + this.elements.get(0);
            return s;
        }

        s += " elements:\n";
        for (String ele : this.elements) {
            s += (ele + "\n");
        }
        return s;
    }
}
