import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dict;

    public DictionaryOfManyTranslations() {
        this.dict = new HashMap<>();
    }

    public void add(String word, String translation) {
        if (this.dict.get(word) == null) {
            this.dict.put(word, new ArrayList<>());
        }

        this.dict.get(word).add(translation);
    }

    public ArrayList<String> translate(String word) {
        if (this.dict.get(word) == null) {
            return new ArrayList<>();
        }

        return this.dict.get(word);
    }

    public void remove(String word) {
        this.dict.remove(word);
    }
}
