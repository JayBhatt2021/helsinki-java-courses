import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BooksFromFile {
    public static void main(String[] args) {
        ArrayList<Book> books = readBooks("books.txt");

        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static ArrayList<Book> readBooks(String file) {
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
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return new ArrayList<>();
    }
}
