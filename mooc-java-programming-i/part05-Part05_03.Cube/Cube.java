public class Cube {
    private int edgeLength;

    public Cube(int edgeLength) {
        this.edgeLength = edgeLength;
    }

    public int volume() {
        return (int) Math.pow(this.edgeLength, 3);
    }

    @Override
    public String toString() {
        return "The length of the edge is " + this.edgeLength + " and the volume " + volume();
    }
}
