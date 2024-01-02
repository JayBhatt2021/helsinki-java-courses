import validating.Calculator;
import validating.Person;

public class Program {
    public static void main(String[] args) {
        System.out.println(new Person("John", 29));

        Calculator c = new Calculator();
        System.out.println("Binomial Coefficent (n = 5, k = 2): " + c.binomialCoefficent(5, 2));
    }
}
