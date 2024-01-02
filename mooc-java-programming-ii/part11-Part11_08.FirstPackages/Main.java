import logic.ApplicationLogic;
import ui.TextInterface;

public class Main {
    public static void main(String[] args) {
        ApplicationLogic al = new ApplicationLogic(new TextInterface());
        al.execute(5);
    }
}
