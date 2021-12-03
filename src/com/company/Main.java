package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //creating scanner object
        Stadium stadium = new Stadium("King Fahad Stadium", 4, 4); //creating Stadium object
        String SeatNum; // initialize Scanner Variable


        boolean quit = false; //boolean to control the main loop
        while (!quit) {

             try { //try block to avoid any error

                 System.out.println("Choose a Number :-");
                 printMenu();
                 int UserInput = scanner.nextInt();

            switch (UserInput) {

                case 1 : // case 1 to reserve new ticket
                    System.out.println("Choose a seat Number");
                     SeatNum = scanner.next();


                    if (stadium.reserve(SeatNum)){

                           System.out.println("Seat "+ SeatNum +" Has Been Reserve");

                    }else  System.out.println("Seat " + SeatNum + " is not there!");
                    break;


                case 2 : //case 2 to cancel the ticket
                    System.out.println("Choose Your Seat Number");
                     SeatNum = scanner.next();


                    if (stadium.cancel(SeatNum)){

                           System.out.println("Seat "+ SeatNum +" Has Been Canceled");

                    }else  System.out.println("Seat " + SeatNum + " is not there!");
                    break;



                case 3 : //case 3 to break the loop and exit the program
                    quit = true;
                    break;


            }


            }catch (Exception e) { // exception to handle the error

             }System.out.println("Error");


        }


    }

    public static void printMenu(){ //to print the menu of choices
        System.out.println("1- Book a New Ticket.\n" +
                "2- Cancel a Ticket.\n"+
                "3- Exit.\n");
    }
}
