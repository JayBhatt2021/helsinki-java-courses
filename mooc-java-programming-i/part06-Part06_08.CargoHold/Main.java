public class Main {
    public static void main(String[] args) {
        Item book = new Item("1984", 1);
        Item clothes = new Item("Clothes", 10);

        Suitcase jaysCase = new Suitcase(10);
        adasCase.addItem(book);
        adasCase.addItem(clothes);

        Suitcase johnsCase = new Suitcase(9);
        johnsCase.addItem(clothes);

        Hold hold = new Hold(500);
        hold.addSuitcase(jaysCase);
        hold.addSuitcase(johnsCase);

        System.out.println("The hold contains the following suitcase items:");
        hold.printItems();
    }
}
