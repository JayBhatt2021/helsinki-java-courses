public class MainProgram {
    public static void main(String[] args) {
        ExerciseManagement exerciseManagement = new ExerciseManagement();

        exerciseManagement.add("Push-ups");
        exerciseManagement.add("Running");
        exerciseManagement.add("Yoga");
        System.out.println("Exercise List: " + exerciseManagement.exerciseList());

        exerciseManagement.markAsCompleted("Running");

        System.out.println("Is Running completed? " + exerciseManagement.isCompleted("Running"));
        System.out.println("Is Yoga completed? " + exerciseManagement.isCompleted("Yoga"));
    }

    // update here your exercise progress
    public static int partsCompleted() {
        return 2;
    }
}
