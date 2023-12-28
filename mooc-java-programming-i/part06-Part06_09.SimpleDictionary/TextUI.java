import java.util.Scanner;

public class TextUI {
    private Scanner scanner;
    private SimpleDictionary dict;

    public TextUI(Scanner scanner, SimpleDictionary dict) {
        this.scanner = scanner;
        this.dict = dict;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            } else if (input.equals("add")) {
                System.out.print("Word: ");
                String word = scanner.nextLine();
                System.out.print("Translation: ");
                String translation = scanner.nextLine();

                this.dict.add(word, translation);
            } else if (input.equals("search")) {
                System.out.print("To be translated: ");
                String word = scanner.nextLine();

                String translation = this.dict.translate(word);
                if (translation == null) {
                    System.out.println("Word " + word + " was not found");
                } else {
                    System.out.println("Translation: " + translation);
                }
            } else {
                System.out.println("Unknown command");
            }
        }

        System.out.println("Bye bye!");
    }
}
