

public class FromParameterToOne {

    public static void main(String[] args) {
        printFromNumberToOne(4);
    }

    public static void printFromNumberToOne(int n) {
        for (int i = n; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
