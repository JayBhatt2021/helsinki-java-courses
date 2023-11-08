import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

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
        
        System.out.println("Print the average of the negative numbers or the "
                + "positive numbers? (n/p)");
        String decision = scanner.nextLine();
        positiveNegativeAverage(decision, inputs);
    }
    
    public static void positiveNegativeAverage(String decision, ArrayList<String> list) {
        double average = 0;
        
        if (decision.equals("n")) {
            average = list.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(i -> i < 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: " + average);
        } else {
            average = list.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(i -> i > 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the postive numbers: " + average);
        }
    }
}
