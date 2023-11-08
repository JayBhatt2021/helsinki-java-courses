
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>(); 
        while (true) {
            String i = scanner.nextLine();
            if (i.equals("")) {
                break;
            }
            list.add(i);
        }
        String largestName = "";
        int sumYears = 0, largestNameLength = 0;
        for (String element : list) {
            String[] parts = element.split(",");
            String name = parts[0];
            int year = Integer.valueOf(parts[1]);
            sumYears += year;
            if (name.length() > largestNameLength) {
                largestName = name;
                largestNameLength = name.length();
            }
        }
        double average = (double) sumYears / list.size();
        System.out.println("Longest name: " + largestName);
        System.out.println("Average of the birth years: " + average);
    }
}
