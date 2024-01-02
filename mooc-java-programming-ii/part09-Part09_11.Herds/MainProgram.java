public class MainProgram {
    public static void main(String[] args) {
        Herd herd = new Herd();

        herd.addToHerd(new Organism(90, 60));
        herd.addToHerd(new Organism(13, 26));
        herd.move(5, 5);

        System.out.println(herd);
    }
}
