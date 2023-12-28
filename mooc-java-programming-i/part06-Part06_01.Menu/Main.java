public class Main {
    public static void main(String[] args) {
        Menu m = new Menu();
        m.addMeal("Smoked salmon, white wine and butter sauce with basil");
        m.addMeal("Seasonal green salad with apple-honey vinegarette");
        m.addMeal("Roasted lamb in a red wine sauce");

        m.printMeals();

        m.clearMenu();
        m.printMeals();
    }
}
