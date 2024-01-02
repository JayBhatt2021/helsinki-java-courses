public class Main {
    public static void main(String[] args) {
        SaveableDictionary dict = new SaveableDictionary("words.txt");

        dict.load();
        dict.delete("olut");
        dict.save();
    }
}
