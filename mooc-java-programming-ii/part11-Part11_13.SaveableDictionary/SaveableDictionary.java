/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author JayBh
 */
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
                this.dictionary.putIfAbsent(parts[0], parts[1]);
                this.dictionary.putIfAbsent(parts[1], parts[0]);
            }
        } catch(IOException ioError) {
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
                        String writtenLine = keyWord + ":" + this.dictionary.get(keyWord);
                        writer.println(writtenLine);
                        previousTranslations.add(keyWord);
                        return keyWord;
                    }).forEachOrdered(keyWord -> {
                        previousTranslations.add(this.dictionary.get(keyWord));
                    });
            }
        } catch (IOException ioError) {
            return false;
        }
        return true;
    }
}
