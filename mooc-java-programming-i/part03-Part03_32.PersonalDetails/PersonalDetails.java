import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String s = scanner.nextLine();

            if (s.equals("")) {
                break;
            }
            list.add(s);
        }

        String longestName = "";
        int sumYears = 0, longestNameLength = 0;

        for (String element : list) {
            String[] parts = element.split(",");
            String name = parts[0];
            int year = Integer.valueOf(parts[1]);

            sumYears += year;
            if (name.length() > longestNameLength) {
                longestName = name;
                longestNameLength = name.length();
            }
        }

        double average = (double)sumYears / list.size();
        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + average);
    }
}
