public class Person implements Saveable {
    private String name;
    private String address;

    @Override
    public void save() {
        this.name = "John Doe";
        this.address = "123 Mary Lane";
    }

    @Override
    public void delete() {
        this.address = "";
    }

    @Override
    public void load(String address) {
        this.address = address;
    }
}
