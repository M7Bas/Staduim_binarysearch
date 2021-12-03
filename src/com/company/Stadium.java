package com.company;

public class Stadium {
    //Declare Variables
    private final String stadiumName;
    private Seat[] seats;

    //Class constructor
    public Stadium(String stadiumName, int numRows, int seatsPerRow) {
        this.stadiumName = stadiumName;

        int numberOfSeats = numRows * seatsPerRow;
        this.seats = new Seat[numberOfSeats]; // Creation of an array that holds all the seats.

        // To give each seat a number [e.g. A05].
        int lastRow = 'A' + (numRows - 1),
            i = 0;
        for (char row = 'A'; row <= lastRow; row++){
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++, i++){
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats[i] = seat;
            }
        }
    }

    // Return the stadium name.
    public String getStadiumName() {
        return stadiumName;
    }

    // Reserve a seat by checking the availability of that seat.
    public boolean reserve (String seatNumber){
        Seat seatToReserve = findSeat(seatNumber);
        if (seatToReserve != null){
            return seatToReserve.reserve();
        }
        return false;
    }

    // Cancel a reserved seat
    public boolean cancel (String seatNumber) {
        Seat seatToCancel = findSeat(seatNumber);
        if (seatToCancel != null) {
            return seatToCancel.cancel();
        }
        return false;
    }

    // Search part.
    private Seat findSeat(String seatNumber){
        int low = 0,
                high = this.seats.length - 1;

        while (low <= high){ // Check if reach the end of the array.
            int mid = (low + high) / 2; // get the mid of the array.
            Seat midValue = seats[mid]; // create temp object to save the middle object.
            int comparisonNumber = midValue.compareTo(seatNumber); // Compare the saved temp object with middle.

            if (comparisonNumber < 0){
                low = mid + 1; // move the low pointer to the middle.
            }
            else if (comparisonNumber > 0){
                high = mid - 1; // move the high pointer to the middle.
            }
            else{
                return midValue; // the seat found.
            }
        }
        return null;
    }
}
