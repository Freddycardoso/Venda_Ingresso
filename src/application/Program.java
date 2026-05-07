package application;

import entities.DomainException;
import entities.Event;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


            System.out.println("---Event Sign Up---");
            System.out.print("Event name: ");
            String eventName = sc.nextLine();
            System.out.print("Total seats: ");
            int totalSeats = sc.nextInt();
            System.out.print("Limit per person: ");
            int limitPerPerson = sc.nextInt();
            Event evento = new Event(eventName, totalSeats, limitPerPerson);
            System.out.println();
            while (true) {
                try {
                    System.out.println("---Start Ticket Sells (Type 0 to End Program)---");
                    System.out.print("Tickets quantity: ");
                    int quantity = sc.nextInt();
                    if (quantity == 0) {
                        System.out.print("End System");
                        break;
                    }
                    evento.sellTickets(quantity);
                    System.out.println("You bought your ticket! Seats remaining: " + evento.getAvailableSeats());
                    System.out.println();

                } catch (DomainException e) {
                    sc.nextLine();
                    System.out.println("Error: " + e.getMessage());
                    System.out.println();

                } catch (Exception e) {
                    sc.nextLine();
                    System.out.println("Unexpected error");
                    System.out.println();

                 }


            }



    sc.close();
    }
}




