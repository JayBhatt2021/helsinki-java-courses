public class MainProgram {
    public static void main(String[] args) {
        Checker c = new Checker();

        System.out.println(c.isDayOfWeek("tue"));
        System.out.println(c.allVowels("aaaaa"));
        System.out.println(c.timeOfDay("23:59:59"));
    }
}
