
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            list.add(Integer.valueOf(input));
        }
        
        positive(list);
    }
    
    public static List<Integer> positive(List<Integer> numbers) {
        List<Integer> positiveList = numbers.stream()
                .filter(i -> i > 0)
                .collect(Collectors.toList());
        return positiveList;
    }
}
