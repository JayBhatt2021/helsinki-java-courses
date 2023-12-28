import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingAFile {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(Paths.get("data.txt"))) {
            while (s.hasNextLine()) {
                String row = s.nextLine();
                System.out.println(row);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
