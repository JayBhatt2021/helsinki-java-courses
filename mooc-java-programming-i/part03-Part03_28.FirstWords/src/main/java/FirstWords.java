
import java.util.Scanner;

public class FirstWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String i = scanner.nextLine();
            if (i.equals("")) {
                break;
            }
            String[] p = i.split(" ");
            System.out.println(p[0]);
        }

    }
}
