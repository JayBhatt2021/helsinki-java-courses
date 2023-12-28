import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> l = new ArrayList<>();
        // implement here a program that reads user input
        // until the user enters 9999
        
        while (true) {
            int n = Integer.valueOf(scanner.nextLine());

            if (n == 9999) {
                break;
            }
            l.add(n);
        }
        
        // after that, the program prints the smallest number
        // and its index -- the smallest number
        // might appear multiple times
        int smallest = l.get(0), index = 0;

        for (int i = 1; i < l.size(); i++) {
            if (smallest > l.get(i)) {
                smallest = l.get(i);
                index = i;
            }
        }
        System.out.println("Smallest number: " + smallest);
        System.out.println("Found at index: " + index);
    }
}
