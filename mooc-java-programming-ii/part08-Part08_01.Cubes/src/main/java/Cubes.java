
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String i = scanner.nextLine();
            if (i.equals("end")) {
                break;
            }
            System.out.println((int)Math.pow(Integer.valueOf(i), 3));
        }
    }
}
