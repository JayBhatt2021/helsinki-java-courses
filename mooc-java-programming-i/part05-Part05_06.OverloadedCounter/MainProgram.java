public class MainProgram {
    public static void main(String[] args) {
        Counter c = new Counter();

        c.increase();
        c.increaseBy(3);
        c.decrease();
        c.decreaseBy(3);
        System.out.println(c.value());
    }
}
