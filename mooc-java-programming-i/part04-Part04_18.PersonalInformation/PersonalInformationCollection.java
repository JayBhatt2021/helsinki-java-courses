import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {
    public static void main(String[] args) {
        // implement here your program that uses the PersonalInformation class
        Scanner scanner = new Scanner(System.in);
        ArrayList<PersonalInformation> infoCollection = new ArrayList<>();

        while (true) {
            System.out.println("First name: ");
            String fn = scanner.nextLine();
            if (fn.isEmpty()) {
                break;
            }

            System.out.println("Last name: ");
            String ln = scanner.nextLine();
            System.out.println("Identification number: ");
            String in = scanner.nextLine();

            infoCollection.add(new PersonalInformation(fn, ln, in));
        }

        for (PersonalInformation p : infoCollection) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }
    }
}
