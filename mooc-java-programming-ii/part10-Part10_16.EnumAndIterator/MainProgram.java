public class MainProgram {
    public static void main(String[] args) {
        Employees university = new Employees();
        university.add(new Person("John", Education.BA));
        university.add(new Person("Bob", Education.MA));
        university.add(new Person("Emily", Education.PHD));

        university.print(Education.MA);
        university.print();

        university.fire(Education.BA);
        university.print();
    }
}
