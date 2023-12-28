import java.util.Scanner;

public class ComparingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f = Integer.valueOf(scanner.nextLine());
        int s = Integer.valueOf(scanner.nextLine());

        if (f == s) {
            System.out.println(f + " is equal to " + s + ".");
        } else if (f > s) {
            System.out.println(f + " is greater than " + s + ".");
        } else {
            System.out.println(f + " is smaller than " + s + ".");
        }
    }
}
