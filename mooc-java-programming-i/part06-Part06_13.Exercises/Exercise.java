public class Exercise {
    private String name;
    private boolean completed;

    public Exercise(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return this.name;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return this.completed;
    }
}
