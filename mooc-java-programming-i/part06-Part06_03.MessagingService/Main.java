public class Main {
    public static void main(String[] args) {
        MessagingService ms = new MessagingService();
        ms.add(new Message("Jay", "Hi there!"));
        ms.add(new Message("Jay", "How are you?"));

        for (Message m : ms.getMessages()) {
            System.out.println(m);
        }
    }
}
