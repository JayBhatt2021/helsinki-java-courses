
import java.util.Scanner;
import java.util.ArrayList;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(); 
        while (true) {
            String i = scanner.nextLine();
            if (i.equals("")) {
                break;
            }
            String[] parts = i.split(",");
            list.add(Integer.valueOf(parts[1]));
        }
        int largestAge = 0;
        for (int element : list) {
            if (element > largestAge) {
                largestAge = element;
            }
        }
        System.out.println("Name of the oldest: " + largestAge);
    }
}
