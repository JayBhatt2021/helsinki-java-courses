public class Main {
    public static void main(String[] args) {
        PaymentTerminal terminal = new PaymentTerminal();
        System.out.println("Terminal status after initialization:");
        System.out.println(terminal);

        double change = terminal.eatAffordably(5.0);
        System.out.println("\nTerminal status after eating affordably with cash:");
        System.out.println("Change returned: " + change);
        System.out.println(terminal);

        change = terminal.eatHeartily(10.0);
        System.out.println("\nTerminal status after eating heartily with cash:");
        System.out.println("Change returned: " + change);
        System.out.println(terminal);

        PaymentCard card = new PaymentCard(7.0);
        boolean successAffordable = terminal.eatAffordably(card);
        System.out.println("\nTerminal status after eating affordably with a payment card:");
        System.out.println("Transaction success: " + successAffordable);
        System.out.println(terminal);

        boolean successHearty = terminal.eatHeartily(card);
        System.out.println("\nTerminal status after eating heartily with a payment card:");
        System.out.println("Transaction success: " + successHearty);
        System.out.println(terminal);

        terminal.addMoneyToCard(card, 20.0);
        System.out.println("\nTerminal status after adding money to the payment card:");
        System.out.println(terminal);
    }
}
