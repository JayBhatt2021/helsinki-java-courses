import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // implement here the program that allows the user to enter 
        // book information and to examine them
        Scanner s = new Scanner(System.in);
        ArrayList<Book> list = new ArrayList<>();

        while (true) {
            System.out.println("Title: ");
            String title = s.nextLine();
            if (title.isEmpty()) {
                break;
            }

            System.out.println("Pages: ");
            int pages = Integer.valueOf(s.nextLine());
            System.out.println("Publication year: ");
            int pYear = Integer.valueOf(s.nextLine());

            list.add(new Book(title, pages, pYear));
        }

        System.out.println("What information will be printed?");
        String decision = s.nextLine();
        for (Book b : list) {
            if (decision.equals("name")) {
                System.out.println(b.getTitle());
            } else {
                System.out.println(b);
            }
        }
    }
}
