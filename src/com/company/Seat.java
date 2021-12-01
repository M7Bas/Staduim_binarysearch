package com.company;

public class Seat implements Comparable<Seat>{

    // Class constructor
    private final String seatNumber;
    private boolean reserved;

    // Class field
    public Seat (String seatNumber){
        this.seatNumber = seatNumber;
        this.reserved = false;
    }

    // Boolean method check if the seat reserved or not
    public boolean reserve() {
        if (!this.reserved) { // if its reserve return true and display caution message
            this.reserved = true;
            System.out.println("this Seat is reserved!");
            return true;
        } else {
            return false;
        }
    }

    public boolean cancel(){
        if (this.reserved) { // if he have no seat to cancel return true.....
            this.reserved = false;
            System.out.println("This seat is not reserved!");
            return true;
        } else {
            return false;
        }
    }

    public String getSeatNumber() { // get number of seat method
        return seatNumber;
    }

    @Override
    public int compareTo(Seat seat) {
        return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    }
}
