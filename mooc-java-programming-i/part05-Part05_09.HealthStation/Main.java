public class Main {
    public static void main(String[] args) {
        Person tom = new Person("Tom", 30, 150, 50);
        HealthStation h = new HealthStation();

        h.feed(tom);
        System.out.println(h.weigh(tom));
        System.out.println(h.weighings());
    }
}
