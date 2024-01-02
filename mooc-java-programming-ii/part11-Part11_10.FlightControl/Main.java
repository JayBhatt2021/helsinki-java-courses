import logic.FlightControl;
import ui.TextUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightControl flightControl = new FlightControl();
        Scanner scanner = new Scanner(System.in);
        TextUI textUI = new TextUI(flightControl, scanner);

        textUI.start();
    }
}
