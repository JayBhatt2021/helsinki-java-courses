import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BooksFromFile {
    public static void main(String[] args) {
        ArrayList<Book> books = readBooks("books.txt");

        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static List<Book> readBooks(String file) {
        ArrayList<Book> books = new ArrayList<>();

        try {
            return Files.lines(Paths.get(file))
                    .map(fileLine -> fileLine.split(","))
                    .filter(splitParts -> splitParts.length >= 4)
                    .map(splitParts ->
                            new Book(
                                    splitParts[0],
                                    Integer.valueOf(splitParts[1]),
                                    Integer.valueOf(splitParts[2]),
                                    splitParts[3]
                            )
                    )
                    .forEach(book -> books.add(book));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return books;
    }
}
