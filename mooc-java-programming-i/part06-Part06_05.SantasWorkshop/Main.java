public class Main {
    public static void main(String[] args) {
        Package p = new Package();
        p.addGift(new Gift("Xbox", 4));
        p.addGift(new Gift("Playstation", 3));

        System.out.println(p.totalWeight());
    }
}
