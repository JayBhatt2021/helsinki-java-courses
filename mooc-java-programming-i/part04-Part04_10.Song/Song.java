public class Song {
    private String name;
    private int length;

    public Song(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String name() {
        return name;
    }

    public int length() {
        return length;
    }
}
