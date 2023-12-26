import java.util.ArrayList;

public class PrintInRange {

    public static void main(String[] args) {
        // Try your method here
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        printNumbersInRange(l, -1, 2);
    }
    
    public static void printNumbersInRange(ArrayList<Integer> numbers, int lowerLimit, int upperLimit) {
        System.out.println("The numbers in the range [" + lowerLimit + ", " + upperLimit + "]");
        for (int e : numbers) {
            if (e >= lowerLimit && e <= upperLimit) {
                System.out.println(e);
            }
        }
    }
}
