import java.util.ArrayList;

public class Herd implements Movable {
    private ArrayList<Movable> herd;

    public Herd() {
        herd = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable m : this.herd) {
            m.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String herdString = "";
        for (Movable movable : this.herd) {
            herdString += movable.toString() + "\n";
        }

        return herdString;
    }
}
