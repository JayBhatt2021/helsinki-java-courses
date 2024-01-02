public class Program {
    public static void main(String[] args) {
        Person p = new Person();

        p.save();
        p.delete();
        p.load("456 Example Road");
    }
}
