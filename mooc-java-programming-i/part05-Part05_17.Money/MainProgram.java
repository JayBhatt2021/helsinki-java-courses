public class MainProgram {
    public static void main(String[] args) {
        Money money1 = new Money(10, 50);
        Money money2 = new Money(5, 75);
        System.out.println("Money 1: " + money1);
        System.out.println("Money 2: " + money2);

        Money sum = money1.plus(money2);
        System.out.println("\nMoney 1 + Money 2: " + sum);

        boolean isLessThan = money1.lessThan(money2);
        System.out.println("\nIs Money 1 less than Money 2? " + isLessThan);

        Money difference = money1.minus(money2);
        System.out.println("\nMoney 1 - Money 2: " + difference);
    }
}
