import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextUI textUI = new TextUI(new Scanner(System.in), new SimpleDictionary());
        textUI.start();
    }
}
