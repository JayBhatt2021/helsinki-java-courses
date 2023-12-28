public class Main {
    public static void main(String[] args) {
        Person bob = new Person("Bob", new SimpleDate(30, 12, 1960), 150, 50);
        Person anotherBob = new Person("Bob", new SimpleDate(30, 12, 1960), 150, 50);

        if (bob.equals(anotherBob)) {
            System.out.println("These two people are the same.");
        }
    }
}
