public class MainProgram {
    public static void main(String[] args) {
        Counter c = new Counter();

        c.increase();
        c.increase(3);
        c.decrease();
        c.decrease(3);
        System.out.println(c.value());
    }
}
