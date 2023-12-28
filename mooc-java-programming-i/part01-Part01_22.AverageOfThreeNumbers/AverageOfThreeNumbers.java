import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int f = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the second number:");
        int s = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the third number:");
        int t = Integer.valueOf(scanner.nextLine());
        System.out.println("The average is " + ((f + s + t) / 3.0));
    }
}
