public class Main {
    public static void main(String[] args) {
        Box box = new Box(5);

        box.add(new Book("George Orwell", "1984", 1));
        box.add(new Book("Leo Tolstoy", "War and Peace", 2));

        box.add(new CD("Eminem", "Killshot", 2018));
        box.add(new CD("Michael Jackson", "Thriller", 1984));

        System.out.println(box);
    }
}
