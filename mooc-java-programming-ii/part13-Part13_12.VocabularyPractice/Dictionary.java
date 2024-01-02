import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Dictionary {
    private final ArrayList<String> words;
    private final HashMap<String, String> translations;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();

        this.add("hola", "hello");
    }

    public String get(String word) {
        return this.translations.get(word);
    }

    public void add(String word, String translation) {
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }

        this.translations.putIfAbsent(word, translation);
    }

    public String getRandomWord() {
        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }
}
