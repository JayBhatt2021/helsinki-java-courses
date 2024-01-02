import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();

        Student s = new Student("John", "Example Address");
        s.study();
        Teacher t = new Teacher("Jane", "Example Address", 50000);

        persons.add(s);
        persons.add(t);
        printPersons(persons);
    }

    public static void printPersons(ArrayList<Person> persons) {
        for (Person p : persons) {
            System.out.println(p);
        }
    }
}
