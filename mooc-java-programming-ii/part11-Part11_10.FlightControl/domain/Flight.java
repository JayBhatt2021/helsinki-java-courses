package domain;

public class Flight {
    private Airplane airplane;
    private Place departureAirport;
    private Place targetAirport;

    public Flight(Airplane airplane, Place departureAirport, Place targetAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.targetAirport = targetAirport;
    }

    public Airplane getAirplane() {
        return this.airplane;
    }

    public Place getDeparturePlace() {
        return this.departureAirport;
    }

    public Place getTargetPlace() {
        return this.targetAirport;
    }

    @Override
    public String toString() {
        return this.airplane.toString() + " (" + this.departureAirport + "-" + this.targetAirport + ")";
    }
}
