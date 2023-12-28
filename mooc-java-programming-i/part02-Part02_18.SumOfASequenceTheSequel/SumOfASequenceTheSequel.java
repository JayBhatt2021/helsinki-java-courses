import java.util.Scanner;

public class SumOfASequenceTheSequel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First number?");
        int f = Integer.valueOf(scanner.nextLine());
        System.out.println("Last number?");
        int l = Integer.valueOf(scanner.nextLine());

        int sum = 0;
        for (int i = f; i <= l; i++) {
            sum += i;
        }
        System.out.println("The sum is " + sum);
    }
}
