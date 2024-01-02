public class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student comparedStudent) {
        return this.getName().compareToIgnoreCase(comparedStudent.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
