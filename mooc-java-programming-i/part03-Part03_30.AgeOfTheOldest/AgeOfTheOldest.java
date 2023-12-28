import java.util.Scanner;
import java.util.ArrayList;

public class AgeOfTheOldest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            String s = scanner.nextLine();
            if (s.equals("")) {
                break;
            }

            String[] parts = s.split(",");
            list.add(Integer.valueOf(parts[1]));
        }

        int largestAge = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int element = list.get(i);

            if (element > largestAge) {
                largestAge = element;
            }
        }
        System.out.println("Name of the oldest: " + largestAge);
    }
}
