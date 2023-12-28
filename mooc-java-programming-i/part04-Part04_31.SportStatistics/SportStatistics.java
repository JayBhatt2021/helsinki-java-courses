import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int games = 0, wins = 0, losses = 0;

        System.out.println("File:");
        String file = scan.nextLine();
        System.out.println("Team:");
        String team = scan.nextLine();

        try (Scanner fs = new Scanner(Paths.get(file))) {
            while (fs.hasNextLine()) {
                String line = fs.nextLine();
                String[] parts = line.split(",");
                String home = parts[0];
                String visit = parts[1];
                int homePoints = Integer.valueOf(parts[2]);
                int visitPoints = Integer.valueOf(parts[3]);

                if (home.equals(team)) {
                    if (homePoints >= visitPoints) {
                        wins++;
                    } else {
                        losses++;
                    }
                    games++;
                }

                if (visit.equals(team)) {
                    if (homePoints <= visitPoints) {
                        wins++;
                    } else {
                        losses++;
                    }
                    games++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Games: " + games);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
}
