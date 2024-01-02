import java.util.HashMap;

public class Abbreviations {
    private HashMap<String, String> dict;
    
    public Abbreviations() {
        this.dict = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviation = sanitizedString(abbreviation);

        if (this.dict.containsKey(abbreviation)) {
            System.out.println("Already in dict");
        } else {
            this.dict.put(abbreviation, explanation);
        }
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        abbreviation = sanitizedString(abbreviation);
        return this.dict.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation) {
        abbreviation = sanitizedString(abbreviation);
        return this.dict.get(abbreviation);
    }
    
    public String sanitizedString(String input) {
        if (input == null) {
            return "";
        }
        
        input = input.toLowerCase();
        input = input.trim();
        return input;
    }
}
