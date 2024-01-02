import java.util.HashMap;

public class Nicknames {
    public static void main(String[] args) {
        HashMap<String, String> nick = new HashMap<>();
        nick.put("matthew", "matt");
        nick.put("michael", "mix");
        nick.put("arthur", "artie");
        System.out.println(nick.get("matthew"));
    }
}
