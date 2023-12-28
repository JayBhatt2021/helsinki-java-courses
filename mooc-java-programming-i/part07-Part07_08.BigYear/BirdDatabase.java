import java.util.ArrayList;
import java.util.Scanner;

public class BirdDatabase {
    private ArrayList<Bird> listOfBirds;
    private boolean foundBird;

    public BirdDatabase() {
        this.listOfBirds = new ArrayList<>();
        this.foundBird = false;
    }

    public void addBird(Scanner input) {
        System.out.print("Name: ");
        String birdName = input.nextLine();
        System.out.print("Name in Latin: ");
        String latinName = input.nextLine();

        listOfBirds.add(new Bird(birdName, latinName));
    }

    public void observeBird(Scanner input) {
        System.out.print("Bird? ");
        String birdName = input.nextLine();

        for (Bird bird : this.listOfBirds) {
            if (birdName.equals(bird.getCommonName())) {
                bird.makeObservation();
                foundBird = true;
            }
        }

        if (!foundBird) {
            System.out.println("Not a bird!");
        }
    }

    public void retrieveAllBirds() {
        for (Bird bird : this.listOfBirds) {
            System.out.println(bird);
        }
    }

    public void retrieveOneBird(Scanner input) {
        System.out.print("Bird? ");
        String birdName = input.nextLine();

        for (Bird bird : this.listOfBirds) {
            if (bird.getCommonName().contains(birdName)) {
                System.out.println(bird);
                foundBird = true;
            }
        }

        if (!foundBird) {
            System.out.println("Not a bird!");
        }
    }
}
