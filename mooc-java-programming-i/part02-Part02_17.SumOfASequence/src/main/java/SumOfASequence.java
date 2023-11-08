
import java.util.Scanner;

public class SumOfASequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Last number?");
        int n = Integer.valueOf(scanner.nextLine());
        System.out.println("The sum is " + (n * (n + 1)) / 2);
    }
}
