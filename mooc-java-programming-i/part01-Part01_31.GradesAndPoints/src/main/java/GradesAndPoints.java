
import java.util.Scanner;

public class GradesAndPoints {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give points [0-100]:");
        int point = Integer.valueOf(scan.nextLine());
        String g = "Grade: ";
        if (point < 0) {
            System.out.println(g + "impossible!");
        } else if (point >= 0 && point <= 49) {
            System.out.println(g + "failed");
        } else if (point >= 50 && point <= 59) {
            System.out.println(g + "1");
        } else if (point >= 60 && point <= 69) {
            System.out.println(g + "2");
        } else if (point >= 70 && point <= 79) {
            System.out.println(g + "3");
        } else if (point >= 80 && point <= 89) {
            System.out.println(g + "4");
        } else if (point >= 90 && point <= 100) {
            System.out.println(g + "5");
        } else {
            System.out.println(g + "incredible!");
        }
    }
}
