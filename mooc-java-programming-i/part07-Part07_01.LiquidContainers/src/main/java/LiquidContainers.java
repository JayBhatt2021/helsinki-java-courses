
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int f = 0, s = 0;
        while (true) {
            System.out.println("First: " + f + "/100");
            System.out.println("Second: " + s + "/100\n");
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            if (amount > 0) {
                switch (command) {
                    case "add":
                        if (f + amount < 100) {
                            f += amount;
                        } else {
                            f = 100;
                        }
                        break;
                    case "move":
                        if (f - amount > 0) {
                            f -= amount;
                        } else {
                            amount = f;
                            f = 0;
                        }
                        if (s + amount < 100) {
                            s += amount;
                        } else {
                            s = 100;
                        }
                        break;
                    case "remove":
                        if (s - amount > 0) {
                            s -= amount;
                        } else {
                            s = 0;
                        }
                        break;
                }
            }
        }
    }

}
