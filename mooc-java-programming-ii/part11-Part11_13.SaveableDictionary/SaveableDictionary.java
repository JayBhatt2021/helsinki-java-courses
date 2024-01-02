import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {
    private final HashMap<String, String> dictionary;
    private String fileName;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.fileName = file;
    }

    public void add(String word, String translation) {
        this.dictionary.putIfAbsent(word, translation);
        this.dictionary.putIfAbsent(translation, word);
    }

    public String translate(String word) {
        return this.dictionary.get(word);
    }

    public void delete(String word) {
        String equivalentTranslation = this.translate(word);

        this.dictionary.remove(word);
        this.dictionary.remove(equivalentTranslation);
    }

    public boolean load() {
        try {
            Scanner fileReader = new Scanner(new File(this.fileName));

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");

                this.add(parts[0], parts[1]);
            }
        } catch (IOException ioError) {
            return false;
        }

        return true;
    }

    public boolean save() {
        try {
            ArrayList<String> previousTranslations = new ArrayList<>();

            try (PrintWriter writer = new PrintWriter(new File(this.fileName))) {
                this.dictionary.keySet().stream()
                        .filter(keyWord -> !(previousTranslations.contains(keyWord)))
                        .map(keyWord -> {
                            writer.println(keyWord + ":" + this.translate(keyWord));
                            previousTranslations.add(keyWord);
                            return keyWord;
                        }).forEachOrdered(keyWord -> {
                            previousTranslations.add(this.translate(keyWord));
                        });
            }
        } catch (IOException ioError) {
            return false;
        }
        return true;
    }
}
