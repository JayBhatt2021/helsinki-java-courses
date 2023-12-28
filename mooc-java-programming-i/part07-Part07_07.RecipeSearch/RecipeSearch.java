import java.util.Scanner;

public class RecipeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File to read: ");
        String fileName = scanner.nextLine();

        RecipeManager recipeManager = new RecipeManager();
        recipeManager.readRecipe(fileName);

        while (true) {
            printUserMenu();
            String userCommand = scanner.nextLine();

            switch (userCommand) {
                case "list":
                    recipeManager.listRecipes();
                    break;
                case "find name":
                    System.out.print("Searched word: ");
                    String nameToSearch = scanner.nextLine();

                    recipeManager.findName(nameToSearch);
                    break;
                case "find cooking time":
                    System.out.print("Max cooking time: ");
                    int maxCookingTime = scanner.nextInt();

                    recipeManager.findCookingTime(maxCookingTime);
                    break;
                case "find ingredient":
                    System.out.print("Ingredient: ");
                    String ingredient = scanner.nextLine();

                    recipeManager.findIngredient(ingredient);
                    break;
                case "stop":
                    return;
            }
        }
    }

    public static void printUserMenu() {
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        System.out.println();
        System.out.print("Enter command: ");
    }
}
