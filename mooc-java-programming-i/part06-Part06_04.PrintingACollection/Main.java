public class Main {
    public static void main(String[] args) {
        // Try out your class here
        SimpleCollection sc = new SimpleCollection("characters");
        System.out.println(sc);
        System.out.println();

        sc.add("magneto");
        System.out.println(sc);
        System.out.println();

        sc.add("mystique");
        System.out.println(sc);
        System.out.println();

        sc.add("phoenix");
        System.out.println(sc);
    }
}
