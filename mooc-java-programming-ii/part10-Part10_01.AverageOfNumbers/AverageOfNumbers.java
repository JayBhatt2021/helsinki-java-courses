import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equals("end")) {
                break;
            }
            inputs.add(userInput);
        }

        double average = inputs.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .average()
                .getAsDouble();

        System.out.println("average of the numbers: " + average);
    }
}
