/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class RecipeManager {
    private ArrayList<String> ingredients;
    private ArrayList<Recipe> listOfRecipes;
    
    public RecipeManager() {
        this.ingredients = new ArrayList<>();
        this.listOfRecipes = new ArrayList<>();
    }
    
    public void readRecipe(String fileName) {
        try (Scanner input = new Scanner(new File(fileName))) {
            while (input.hasNextLine()) {
                String recipeName = input.nextLine();
                int cookingTime = Integer.valueOf(input.nextLine());
                Recipe recipe = new Recipe(recipeName, cookingTime);
                listOfRecipes.add(recipe);
                while (input.hasNextLine()) {
                    String ingredient = input.nextLine();
                    if (ingredient.isEmpty()) {
                        break;
                    }  
                    recipe.addIngredients(ingredient);
                }            
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void listRecipes() {
        System.out.println("Recipes: ");
        for (Recipe recipe : listOfRecipes) {
            System.out.println(recipe);
        }
    }
    
    public void findName(String nameToSearch) {
        System.out.println("Recipes: ");
        for (Recipe recipe : listOfRecipes) {
            if (recipe.getRecipeName().contains(nameToSearch)) {
                System.out.println(recipe);
            }
        }
    }
    
    public void findCookingTime(int maxCookingTime) {
        System.out.println("Recipes: ");
        for (Recipe recipe : listOfRecipes) {
            if (recipe.getCookingTime() <= maxCookingTime) {
                System.out.println(recipe);
            }
        }
    }   
    
    public void findIngredient(String ingredient) {
        for (int i = 0; i < listOfRecipes.size(); i++) {
            if (listOfRecipes.get(i).getIngredients().contains(ingredient)) {
                System.out.println(listOfRecipes.get(i));
            }
        }
    }
}
