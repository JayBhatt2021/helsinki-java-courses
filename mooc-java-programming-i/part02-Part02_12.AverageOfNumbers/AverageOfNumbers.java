import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0, sum = 0;

        while (true) {
            System.out.println("Give a number:");
            int n = Integer.valueOf(scanner.nextLine());

            if (n == 0) {
                break;
            }
            count++;
            sum += n;
        }
        System.out.println("Average of the numbers: " + ((double)sum / count));
    }
}
