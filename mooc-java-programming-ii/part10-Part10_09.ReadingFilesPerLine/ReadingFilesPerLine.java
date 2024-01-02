import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadingFilesPerLine {
    public static void main(String[] args) {
        ArrayList<String> fileRows = read("data.txt");

        for (String row : fileRows) {
            System.out.println(row);
        }
    }

    public static ArrayList<String> read(String file) {
        ArrayList<String> fileRows = new ArrayList<>();

        try {
            Files.lines(Paths.get(file)).forEach(row -> fileRows.add(row));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return fileRows;
    }
}
