
import java.util.Scanner;

public class SquareRootOfSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.valueOf(scanner.nextLine());
        int y = Integer.valueOf(scanner.nextLine());
        double s = Math.sqrt(x + y);
        System.out.println(s);
    }
}
