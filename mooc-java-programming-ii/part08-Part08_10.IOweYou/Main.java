public class Main {
    public static void main(String[] args) {
        IOU i = new IOU();

        i.setSum("Jay", 100.0);
        System.out.println(i.howMuchDoIOweTo("Jay"));
        System.out.println(i.howMuchDoIOweTo("Bob"));
    }
}
