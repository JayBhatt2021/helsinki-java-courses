public class Main {
    public static void main(String[] args) {
        Abbreviations a = new Abbreviations();
        a.addAbbreviation("lol", "laugh out loud");
        a.addAbbreviation("lol", "laugh out loud");
        a.addAbbreviation("btw", " by the WAY ");

        System.out.println(a.hasAbbreviation("btw"));
        System.out.println(a.findExplanationFor("btw"));
    }
}
