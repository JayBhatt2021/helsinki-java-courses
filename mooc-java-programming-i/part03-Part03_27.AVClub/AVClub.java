import java.util.Scanner;

public class AVClub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            String[] pieces = input.split(" ");
            for (String e : pieces) {
                if (e.contains("av")) {
                    System.out.println(e);
                }
            }
        }
    }
}
