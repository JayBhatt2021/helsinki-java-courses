public class Main {
    public static void main(String[] args) {
        MessageService ms = new MessageService();
        ms.add("Jay", "Hi there!");
        ms.add("Jay", "How are you?");

        for (Message m : ms.getMessages()) {
            System.out.println(m);
        }
    }
}
