import java.util.Scanner;

public class AdditionFormula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int f = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Give the second number:");
        int s = scanner.nextInt();
        System.out.println(f + " + " + s + " = " + (f + s));
    }
}
