public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();

        System.out.println(s.isEmpty());

        s.add("Bob");
        s.add("Jay");
        System.out.println(s.take());

        for (String n : s.values()) {
            System.out.println(n);
        }
    }
}
