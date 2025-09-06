package assignment1;

public class HotelReservation extends Reservation{
    private Hotel hotel;
    private String roomType;
    private int numNights;
    private int pricePerNight;

    public HotelReservation (String name, Hotel hotel, String type, int numNights){
        super(name);
        this.hotel = hotel;
        this.roomType = type;
        this.numNights = numNights;
        this.pricePerNight = this.hotel.reserveRoom(this.roomType);
    }

    public int getNumOfNights(){
        return this.numNights;
    }

    public int getCost(){
        return (this.pricePerNight*this.numNights);
    }

    public boolean equals(Object objInput){
        if (objInput instanceof BnBReservation && this instanceof BnBReservation){
            if (((Reservation)this).reservationName().equals(((Reservation) objInput).reservationName())
                    && this.hotel == ((HotelReservation) objInput).hotel &&
                    this.roomType.equals(((HotelReservation) objInput).roomType)
                    && this.numNights == ((HotelReservation) objInput).numNights
                    && this.pricePerNight == ((HotelReservation) objInput).pricePerNight){
                return true;
            }
        } else if (objInput instanceof HotelReservation && !(this instanceof BnBReservation) && !(objInput instanceof BnBReservation)){
            if (((Reservation)this).reservationName().equals(((Reservation) objInput).reservationName())
                && this.hotel == ((HotelReservation) objInput).hotel &&
                    this.roomType.equals(((HotelReservation) objInput).roomType)
                && this.numNights == ((HotelReservation) objInput).numNights
                && this.pricePerNight == ((HotelReservation) objInput).pricePerNight){
                return true;
            }
        }
        return false;
    }
}

