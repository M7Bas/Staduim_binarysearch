package com.company;

public class Stadium {
    private final String stadiumName;
    private Seat[] seats;

    public Stadium(String stadiumName, int numRows, int seatsPerRow) {
        this.stadiumName = stadiumName;

        int numberOfSeats = numRows * seatsPerRow;
        this.seats = new Seat[numberOfSeats];

        int lastRow = 'A' + (numRows - 1),
            i = 0;
        for (char row = 'A'; row <= lastRow; row++){
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++, i++){
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats[i] = seat;
            }
        }
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public boolean reserve (String seatNumber){
        Seat seatToReserve = findSeat(seatNumber);
        if (seatToReserve != null){
            return seatToReserve.reserve();
        }
        return false;
    }

    public boolean cancel (String seatNumber) {
        Seat seatToCancel = findSeat(seatNumber);
        if (seatToCancel != null) {
            return seatToCancel.cancel();
        }
        return false;
    }

    public Seat findSeat(String seatNumber){
        int low = 0,
                high = this.seats.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;
            Seat midValue = seats[mid];
            int comparisonNumber = midValue.getSeatNumber().compareTo(seatNumber);

            if (comparisonNumber < 0){
                low = mid + 1;
            }
            else if (comparisonNumber > 0){
                high = mid - 1;
            }
            else{
                return midValue;
            }
        }
        System.out.println("Seat " + seatNumber + " is not there!");
        return null;
    }
}
