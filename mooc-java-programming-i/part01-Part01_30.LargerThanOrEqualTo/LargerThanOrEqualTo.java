import java.util.Scanner;

public class LargerThanOrEqualTo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give the first number:");
        int f = Integer.valueOf(scan.nextLine());
        System.out.println("Give the second number:");
        int s = Integer.valueOf(scan.nextLine());

        if (f == s) {
            System.out.println("The numbers are equal!");
        } else if (f > s) {
            System.out.println("Greater number is: " + f);
        } else {
            System.out.println("Greater number is: " + s);
        }
    }
}
