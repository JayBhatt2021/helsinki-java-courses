public class Money {
    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        if (cents > 99) {
            euros += (cents / 100);
            cents %= 100;
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

    @Override
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

        return new Money(sumEuros, sumCents);
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
        int euroDiff = this.euros - decreaser.euros;
        int centsDiff = this.cents - decreaser.cents;

        if (centsDiff < 0) {
            centsDiff = 100 - Math.abs(centsDiff);
            euroDiff--;
        }

        if (euroDiff < 0) {
            return new Money(0, 0);
        }

        return new Money(euroDiff, centsDiff);
    }
}
