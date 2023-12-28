import java.util.ArrayList;
import java.util.Scanner;

public class NameOfTheOldest {
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

        String s = list.get(0), oldestName = "";
        int oldestAge = 0;

        for (int i = 1; i < list.size(); i++) {
            String element = list.get(i);
            String[] parts = element.split(",");
            String name = parts[0];
            int age = Integer.valueOf(parts[1]);

            if (age > oldestAge) {
                oldestName = name;
                oldestAge = age;
            }
        }
        System.out.println("Name of the oldest: " + oldestName);
    }
}
