import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        JokeManager manager = new JokeManager();
        Scanner scanner = new Scanner(System.in);
        UserInterface interfac = new UserInterface(manager, scanner);

        interfac.start();
    }
}
