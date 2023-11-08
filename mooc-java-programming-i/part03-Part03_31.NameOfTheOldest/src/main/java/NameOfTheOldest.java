
import java.util.ArrayList;
import java.util.Scanner;

public class NameOfTheOldest {

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
        String s = list.get(0), largestName = "";
        int largestAge = 0;
        for (String element : list) {
            String[] parts = element.split(",");
            String name = parts[0];
            int age = Integer.valueOf(parts[1]);
            if (age > largestAge) {
                largestName = name;
                largestAge = age;
            }
        }
        System.out.println("Name of the oldest: " + largestName);

    }
}
