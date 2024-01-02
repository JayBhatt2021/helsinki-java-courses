public class Main {
    public static void main(String[] args) {
        Hold hold = new Hold(50);

        Suitcase suitcase1 = new Suitcase(20);
        suitcase1.addItem(new Item("Book", 2));
        suitcase1.addItem(new Item("Laptop", 3));

        Suitcase suitcase2 = new Suitcase(15);
        suitcase2.addItem(new Item("Clothes", 5));
        suitcase2.addItem(new Item("Toiletries", 2));

        hold.addSuitcase(suitcase1);
        hold.addSuitcase(suitcase2);

        System.out.println("Hold contents:");
        hold.printItems();

        System.out.println("Hold information: " + hold);
    }
}
