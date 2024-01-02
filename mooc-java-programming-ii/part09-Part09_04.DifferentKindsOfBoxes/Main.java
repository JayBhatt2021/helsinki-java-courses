public class Main {
    public static void main(String[] args) {
        OneItemBox box = new OneItemBox();
        box.add(new Item("Xbox", 2));
        box.add(new Item("PlayStation", 1));

        System.out.println(box.isInBox(new Item("Xbox")));
        System.out.println(box.isInBox(new Item("PlayStation")));
    }
}
