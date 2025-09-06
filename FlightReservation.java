package assignment1;

public class FlightReservation extends Reservation{
    private Airport departure;
    private Airport arrival;

    public FlightReservation (String name, Airport departure, Airport arrival){
        super(name);
        this.departure = departure;
        this.arrival = arrival;

        if (departure == arrival){
            throw new IllegalArgumentException("The departure airport and arrival airport cannot be the same.");
        }
    }

    public int getCost(){
        int distance = Airport.getDistance(this.arrival, this.departure);
        double cost = 53.75*100 + this.departure.getFees() + this.arrival.getFees();
        double fuelCost = (distance/167.52)*124;
        cost += fuelCost;

        if (cost > (int)cost){
            cost = (int)cost + 1;
        }
        return (int)cost;
    }

    public boolean equals(Object objInput){
        if (objInput instanceof FlightReservation){
            if (((FlightReservation)objInput).reservationName().equals(this.reservationName())
                    && ((FlightReservation)objInput).departure == this.departure &&
                    ((FlightReservation)objInput).arrival == this.arrival){
                return true;
            }
        }
        return false;
    }
}

