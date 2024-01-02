public class Main {
    public static void main(String[] args) {
        CustomTacoBox c = new CustomTacoBox(5);

        c.eat();
        System.out.println(c.tacosRemaining());
    }
}
