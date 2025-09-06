package assignment1;

public class Basket {
    private Reservation[] reservations;
    private int size;

    public Basket (){
        this.reservations = new Reservation[10];
        size = 0;
    }

    public Reservation[] getProducts(){
        Reservation[] copy = new Reservation[this.reservations.length];
        for (int i = 0; i<size; i++){
            copy[i] = this.reservations[i];
        }
        return copy;
    }

    public int add (Reservation res){
        if (this.reservations.length == size){
            resize();
        }
        this.reservations[size] = res;
        size += 1;
        return size;
    }

    private void resize(){
        Reservation[] bigger = new Reservation[this.reservations.length*2];
        for (int i = 0; i < size; i++){
            bigger[i] = this.reservations[i];
        }
        reservations = bigger;
    }

    public boolean remove (Reservation res){
        for (int i = 0; i < size; i++){
            if (this.reservations[i].equals(res)){
                this.reservations[i] = null;

                for (int j = i; j < size; j++){
                    this.reservations[j] = this.reservations[j+1];
                }
                size -= 1;
                return true;
            }
        }
        return false;
    }

    public void clear(){
        this.reservations = new Reservation[0];
        size = 0;
    }

    public int getNumOfReservations(){
        return this.size;
    }

    public int getTotalCost(){
        int totalCost = 0;
        for (int i = 0; i < this.size; i++){
            totalCost += this.reservations[i].getCost();
        }
        return totalCost;
    }
}
