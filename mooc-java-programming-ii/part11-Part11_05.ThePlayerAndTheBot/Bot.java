public class Bot extends Player {
    @Override
    public void play() {
        System.out.print("The Bot ");
        super.printName();
        System.out.println(" plays!");
    }

    public void addMove(String move) {
        System.out.println("The Bot " + move);
    }
}
