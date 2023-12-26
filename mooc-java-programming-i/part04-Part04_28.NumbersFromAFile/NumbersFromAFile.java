import java.util.ArrayList;
import java.nio.file.Paths;
import java.util.Scanner;

public class NumbersFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("File? ");
        String file = scanner.nextLine();
        System.out.print("Lower bound? ");
        int lowerBound = Integer.valueOf(scanner.nextLine());
        System.out.print("Upper bound? ");
        int upperBound = Integer.valueOf(scanner.nextLine());
        try (Scanner fs = new Scanner(Paths.get(file))) {
            while (fs.hasNextLine()) {
                list.add(Integer.valueOf(fs.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int count = 0;
        for (int ele : list) {
            if (ele >= lowerBound && ele <= upperBound) {
                count++;
            }
        }
        System.out.println("Numbers: " + count);
    }

}
