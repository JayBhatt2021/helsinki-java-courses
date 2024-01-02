public class Program {
    public static void main(String[] args) {
        Pipe<String> pipe = new Pipe<>();
        pipe.putIntoPipe("dibi");
        pipe.putIntoPipe("dab");
        pipe.putIntoPipe("dab");
        pipe.putIntoPipe("daa");

        while (pipe.isInPipe()) {
            System.out.println(pipe.takeFromPipe());
        }
    }
}
