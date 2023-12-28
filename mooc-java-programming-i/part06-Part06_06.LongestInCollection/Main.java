public class Main {
    public static void main(String[] args) {
        SimpleCollection c = new SimpleCollection("characters");
        System.out.println("Longest: " + c.longest());

        c.add("magneto");
        c.add("mystique");
        c.add("phoenix");

        System.out.println("Longest: " + c.longest());
    }
}
