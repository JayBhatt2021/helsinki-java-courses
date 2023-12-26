
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

    public Money plus(Money addition) {
        int sumEuros = this.euros + addition.euros;
        int sumCents = this.cents + addition.cents;
        Money newMoney = new Money(sumEuros, sumCents);
        return newMoney;
    }
    
    public boolean lessThan(Money compared) {
        if (this.euros < compared.euros) {
            return true;
        }
        if (this.euros == compared.euros && this.cents < compared.cents) {
            return true;
        }
        return false;
    }
    
    public Money minus(Money decreaser) {
        int euroDif = this.euros - decreaser.euros;
        int centsDif = this.cents - decreaser.cents;
        if (centsDif < 0) {
            centsDif = 100 - Math.abs(centsDif);
            euroDif--;
        }
        if (euroDif < 0) {
            return new Money(0, 0);
        }
        return new Money(euroDif, centsDif);
    }
}
