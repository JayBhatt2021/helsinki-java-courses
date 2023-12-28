public class FromOneToParameter {
    public static void main(String[] args) {
        printUntilNumber(4);
    }
    
    public static void printUntilNumber(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
}
