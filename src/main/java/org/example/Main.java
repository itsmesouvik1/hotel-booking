package org.example;

import org.example.service.ReservationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Portal");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total rooms : ");
        int size = sc.nextInt();
        ReservationService reservationService = new ReservationService(size);
        String ch = "Y";
        do {
            System.out.println("Enter booking dates : ");
            int booking[] = new int[2];
            booking[0] = sc.nextInt();
            booking[1] = sc.nextInt();
            System.out.println(reservationService.isRoomAvailable(booking));
            System.out.println("Enter 'Y' to continue : or Enter 'D' to see Reservation Status");
            ch = sc.next();
            if (ch.equalsIgnoreCase("D")) reservationService.displayHotel();
        } while (ch.equalsIgnoreCase("Y") || ch.equalsIgnoreCase("D"));
    }
}