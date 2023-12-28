import java.util.Scanner;

public class GiftTax {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Value of the gift?");
        double price = Double.valueOf(scan.nextLine());

        if (price < 5000) {
            System.out.println("No tax!");
        } else if (price >= 5000 && price < 25000) {
            System.out.println("Tax: " + (100 + (price - 5000) * 0.08));
        } else if (price >= 25000 && price < 55000) {
            System.out.println("Tax: " + (1700 + (price - 25000) * 0.10));
        } else if (price >= 55000 && price < 200000) {
            System.out.println("Tax: " + (4700 + (price - 55000) * 0.12));
        } else if (price >= 200000 && price < 1000000) {
            System.out.println("Tax: " + (22100 + (price - 200000) * 0.15));
        } else {
            System.out.println("Tax: " + (142100 + (price - 1000000) * 0.17));
        }
    }
}
