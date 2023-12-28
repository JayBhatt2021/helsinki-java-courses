import java.util.Scanner;

public class OnlyPositives {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Give a number:");
            int x = Integer.valueOf(scanner.nextLine());

            if (x < 0) {
                System.out.println("Unsuitable number");
                continue;
            }
            if (x == 0) {
                break;
            }
            System.out.println(x * x);
        }
    }
}
