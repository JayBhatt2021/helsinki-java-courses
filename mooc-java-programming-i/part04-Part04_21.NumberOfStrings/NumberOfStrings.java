
import java.util.Scanner;

public class NumberOfStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            String i = scanner.nextLine();
            if (i.equals("end")) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
