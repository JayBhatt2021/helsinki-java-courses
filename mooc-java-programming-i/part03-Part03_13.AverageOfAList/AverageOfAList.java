import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfAList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> l = new ArrayList<>();

        // implement here a program, that first reads user input
        // adding them on a list until user gives -1.
        // Then it computes the average of the numbers on the list
        // and prints it.
        while (true) {
            int n = Integer.valueOf(scanner.nextLine());

            if (n == -1) {
                break;
            }
            l.add(n);
        }
        
        System.out.println("");

        int sum = 0;
        for (int n : l) {
            sum += n;
        }
        System.out.println("Average: " + (sum * 1.0 / l.size()));
    }
}
