
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        HashMap<String, String> nick = new HashMap<>();
        nick.put("matthew", "matt");
        nick.put("michael", "mix");
        nick.put("arthur", "artie");
        System.out.println(nick.get("matthew"));
    }

}
