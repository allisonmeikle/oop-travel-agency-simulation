package assignment1;

public class Customer {
    private String name;
    private int balance;
    private Basket reservations;

    public Customer (String name, int balance){
        this.name = name;
        this.balance = balance;
        this.reservations = new Basket();
    }

    public String getName(){
        return this.name;
    }

    public int getBalance(){
        return this.balance;
    }

    public Basket getBasket(){
        return this.reservations;
    }

    public int addFunds(int numCents){
        if (numCents < 0){
            throw new IllegalArgumentException("You cannot add a negative amount of money to your balance.");
        }
        this.balance += numCents;
        return this.balance;
    }

    public int addToBasket(Reservation newRes){
        if (newRes.reservationName().equals(this.name)){
            this.reservations.add(newRes);
            return this.reservations.getNumOfReservations();
        }
        throw new IllegalArgumentException("The name on this reservation does not match the customer name.");
    }

    public int addToBasket(Hotel hotel, String roomType, int numNights, boolean breakfast){
        if (breakfast){
            this.reservations.add(new BnBReservation(this.name, hotel, roomType, numNights));
        } else {
            this.reservations.add(new HotelReservation(this.name, hotel, roomType, numNights));
        }
        return this.reservations.getNumOfReservations();
    }

    public int addToBasket(Airport a1, Airport a2){
        try{
            this.reservations.add(new FlightReservation(this.name, a1, a2));
            return this.reservations.getNumOfReservations();
        }
        catch (IllegalArgumentException e){
            return this.reservations.getNumOfReservations();
        }

    }

    public boolean removeFromBasket(Reservation res){
        return this.reservations.remove(res);
    }

    public int checkOut (){
        int totalCost = this.reservations.getTotalCost();
        if (totalCost > this.balance){
            throw new IllegalStateException("You have an insufficient balance to make these reservations.");
        }
        this.balance -= totalCost;
        this.reservations.clear();
        return this.balance;
    }
}

