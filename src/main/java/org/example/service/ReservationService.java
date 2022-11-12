package org.example.service;

import org.example.model.BookingRange;
import org.example.model.ReservationStatus;
import org.example.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReservationService {

    private List<Room> hotel;
    private int capacity;

    public ReservationService(int capacity) {
        this.capacity = capacity;
        hotel = new ArrayList<>();
    }

    public ReservationStatus isRoomAvailable(int[] bookingDate) {
        if (bookingDate[0] < 0 || bookingDate[0] > 365) return ReservationStatus.DECLINE;
        if (bookingDate[1] < 0 || bookingDate[1] > 365) return ReservationStatus.DECLINE;

        boolean isBookingPossible = false;
        // O(n^2)
        for (Room room : hotel) {
            List<BookingRange> dates = room.getDates();
            for (int i = 0; i < dates.size(); i++) {
                if (bookingDate[0] > dates.get(i).getEndDay() || bookingDate[1] < dates.get(i).getStartDay()) {
                    if (i == dates.size() - 1) {
                        isBookingPossible = reserveRoom(bookingDate, room, dates);
                        break;
                    } else {
                        if (bookingDate[1] < dates.get(i + 1).getStartDay()) {
                            isBookingPossible = reserveRoom(bookingDate, room, dates);
                            break;
                        }
                    }
                }
            }
            if (isBookingPossible) break;
        }
        if (hotel.size() < capacity && !isBookingPossible) {
            Room room = new Room();
            room.setDates(Arrays.asList(new BookingRange(bookingDate[0], bookingDate[1])));
            hotel.add(room);
            isBookingPossible = true;
        }

        return isBookingPossible ? ReservationStatus.ACCEPT : ReservationStatus.DECLINE;
    }

    private boolean reserveRoom(int[] bookingDate, Room room, List<BookingRange> dates) {
        dates.add(new BookingRange(bookingDate[0], bookingDate[1]));
        room.setDates(dates);
        return true;
    }

    public void displayHotel() {
        for (int i = 0; i < hotel.size(); i++) {
            System.out.println("Room - " + i);
            for (int j = 0; j < hotel.get(i).getDates().size(); j++)
                System.out.println("Booking " + j + " : " + "Start Day : " + hotel.get(i).getDates().get(j).getStartDay() + ", End Day : " + hotel.get(i).getDates().get(j).getEndDay());        }
    }

}
