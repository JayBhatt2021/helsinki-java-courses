import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();
        
        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            
            if (name.isEmpty()) {
                System.out.println();
                break;
            }    
                    
            System.out.println("Input the age recommendation: ");
            int ageRecommendation = Integer.valueOf(scanner.nextLine());
            
            bookList.add(new Book(name, ageRecommendation));
        }
        
        System.out.print(bookList.size() + " books in total.\n\nBooks:");
        
        Comparator<Book> c = Comparator.comparing(Book::getAgeRecommendation)
                                       .thenComparing(Book::getName);
        Collections.sort(bookList, c);
        
        for (Book b : bookList) {
            System.out.println(b);
        }
    }
}
