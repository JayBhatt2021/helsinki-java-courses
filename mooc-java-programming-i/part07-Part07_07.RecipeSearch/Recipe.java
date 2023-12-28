import java.util.ArrayList;

public class Recipe {
    private String recipeName;
    private int cookingTime;
    private ArrayList<String> ingredients;

    public Recipe(String recipeName, int cookingTime) {
        this.recipeName = recipeName;
        this.cookingTime = cookingTime;
        this.ingredients = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.recipeName + ", cooking time: " + this.cookingTime;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public int getCookingTime() {
        return this.cookingTime;
    }

    public void addIngredients(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }
}
