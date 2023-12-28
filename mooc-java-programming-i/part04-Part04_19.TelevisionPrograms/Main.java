import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // implement here your program that uses the TelevisionProgram class
        Scanner scanner = new Scanner(System.in);
        ArrayList<TelevisionProgram> programs = new ArrayList<>();

        while (true) {
            System.out.println("Name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }

            System.out.println("Duration: ");
            int dur = Integer.valueOf(scanner.nextLine());

            programs.add(new TelevisionProgram(name, dur));
        }

        System.out.println("Program's maximum duration? ");
        int maxDur = Integer.valueOf(scanner.nextLine());
        for (TelevisionProgram p : programs) {
            if (p.getDuration() <= maxDur) {
                System.out.println(p);
            }
        }
    }
}
