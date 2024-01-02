import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {
    private Random rand;
    private ArrayList<Integer> numbers;

    public LotteryRow() {
        this.rand = new Random();

        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        this.numbers = new ArrayList<>();

        while (this.numbers.size() != 7) {
            int drawnNumber = this.rand.nextInt(40) + 1;

            if (!this.containsNumber(drawnNumber)) {
                this.numbers.add(drawnNumber);
            }
        }
    }

    public boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }
}
