public class Main {
    public static void main(String[] args) {
        SimpleDate currentDate = new SimpleDate(15, 10, 2023);
        System.out.println("Current Date: " + currentDate);

        System.out.println("\nAdvancing one day:");
        currentDate.advance();
        System.out.println("New Date: " + currentDate);

        System.out.println("\nAdvancing five days:");
        currentDate.advance(5);
        System.out.println("New Date: " + currentDate);

        System.out.println("\nCreating a new date after 10 days:");
        SimpleDate futureDate = currentDate.afterNumberOfDays(10);
        System.out.println("Future Date: " + futureDate);
    }
}
