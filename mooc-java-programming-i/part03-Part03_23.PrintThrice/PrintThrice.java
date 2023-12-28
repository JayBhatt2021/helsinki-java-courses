import java.util.Scanner;

public class PrintThrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.print("Give a word: ");
        String w = scanner.nextLine();

        for (int i = 0; i <= 2; i++) {
            System.out.print(w);
        }
    }
}
