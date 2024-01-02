import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> handOfCards;

    public Hand() {
        this.handOfCards = new ArrayList<>();
    }

    public void add(Card card) {
        this.handOfCards.add(card);
    }

    public void print() {
        Iterator<Card> iterator = this.handOfCards.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void sort() {
        Collections.sort(this.handOfCards);
    }

    public int totalHandValue() {
        int totalHandValue = 0;
        Iterator<Card> iterator = this.handOfCards.iterator();

        while (iterator.hasNext()) {
            totalHandValue += iterator.next().getValue();
        }

        return totalHandValue;
    }

    public void sortBySuit() {
        Collections.sort(this.handOfCards, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand comparedHand) {
        return this.totalHandValue() - comparedHand.totalHandValue();
    }
}
