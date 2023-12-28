import java.util.ArrayList;
import java.util.Scanner;

public class RememberTheseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            int n = Integer.valueOf(scanner.nextLine());

            if (n == -1) {
                break;
            }
            numbers.add(n);
        }

        for (int n : numbers) {
            System.out.println(n);
        }
    }
}
