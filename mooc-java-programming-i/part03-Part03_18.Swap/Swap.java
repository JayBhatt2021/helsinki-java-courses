import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 3;
        array[2] = 5;
        array[3] = 7;
        array[4] = 9;

        for (int n : array) {
            System.out.println(n);
        }
        System.out.println("");

        // Implement here
        // asking for the two indices
        // and then swapping them
        System.out.println("Give two indices to swap:");
        int firstIndex = Integer.valueOf(scanner.nextLine());
        int lastIndex = Integer.valueOf(scanner.nextLine());

        int temp = array[firstIndex];
        array[firstIndex] = array[lastIndex];
        array[lastIndex] = temp;
        
        System.out.println("");
        for (int n : array) {
            System.out.println(n);
        }
    }
}
