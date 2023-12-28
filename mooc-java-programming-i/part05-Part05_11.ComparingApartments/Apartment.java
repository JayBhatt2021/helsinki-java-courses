public class Apartment {
    private int rooms;
    private int squares;
    private int pricePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {
        if (this.rooms > compared.rooms) {
            return true;
        }
        if (this.rooms < compared.rooms) {
            return false;
        }
        return this.squares > compared.squares;
    }

    public int priceDifference(Apartment compared) {
        int ownPrice = this.squares * this.pricePerSquare;
        int comparedPrice = compared.squares * compared.pricePerSquare;
        return Math.abs(ownPrice - comparedPrice);
    }

    public boolean moreExpensiveThan(Apartment compared) {
        int ownPrice = this.squares * this.pricePerSquare;
        int comparedPrice = compared.squares * compared.pricePerSquare;
        return ownPrice > comparedPrice;
    }
}
