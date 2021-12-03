package com.company;

public class Seat {

    // Class field
    private final String seatNumber;
    private boolean reserved;


    // Class constructor
    public Seat (String seatNumber){
        this.seatNumber = seatNumber;
        this.reserved = false;
    }

    // Boolean method check if the seat reserved or not
    public boolean reserve() {
        if (!this.reserved) { // if its reserve return true and display caution message
            this.reserved = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean cancel(){
        if (this.reserved) { // if he has no seat to cancel return true.....
            this.reserved = false;
            return true;
        } else {
            return false;
        }
    }

    public String getSeatNumber() { // get number of seat method
        return seatNumber;
    }

    public int compareTo(String seatNumber) {
        return this.seatNumber.compareToIgnoreCase(seatNumber);
    }
}
