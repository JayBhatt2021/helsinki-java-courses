package validating;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.isEmpty() || name.length() > 40) {
            throw new IllegalArgumentException("Name cannot be null, empty, or over 40 characters.");
        }
        this.name = name;

        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age cannot be less than 0 or greater than 120.");
        }
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
