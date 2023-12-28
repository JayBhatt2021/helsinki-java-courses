import java.util.Scanner;

public class mainProgram {
    public static void main(String[] args) {
        // NB! Do not create other scanner objects than the one below
        // if and when you create other classes, pass the scanner to them
        // as a parameter
        Scanner scan = new Scanner(System.in);
        BirdDatabase birdie = new BirdDatabase();

        while (true) {
            System.out.print("? ");
            String userCommand = scan.nextLine();

            switch (userCommand) {
                case "Add":
                    birdie.addBird(scan);
                    break;
                case "Observation":
                    birdie.observeBird(scan);
                    break;
                case "All":
                    birdie.retrieveAllBirds();
                    break;
                case "One":
                    birdie.retrieveOneBird(scan);
                    break;
                case "Quit":
                    return;
                default:
                    System.out.println("Sorry. Unsupported option.");
                    break;
            }
        }
    }
}
