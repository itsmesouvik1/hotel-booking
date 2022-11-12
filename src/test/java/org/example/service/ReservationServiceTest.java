package org.example.service;

import org.example.model.ReservationStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {

    @Test
    public void testDaysRange1() {
        ReservationService reservationService = new ReservationService(1);
        assertEquals(reservationService.isRoomAvailable(new int[]{-4, 2}), ReservationStatus.DECLINE);
    }

    @Test
    public void testDaysRange2() {
        ReservationService reservationService = new ReservationService(1);
        assertEquals(reservationService.isRoomAvailable(new int[]{200, 400}), ReservationStatus.DECLINE);
    }

    @Test
    public void testBookingStatus1() {
        ReservationService reservationService = new ReservationService(3);
        assertEquals(reservationService.isRoomAvailable(new int[]{0, 5}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{7, 13}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{3, 9}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{5, 7}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{6, 6}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{0, 4}), ReservationStatus.ACCEPT);
    }

    @Test
    public void testBookingStatus2() {
        ReservationService reservationService = new ReservationService(3);
        assertEquals(reservationService.isRoomAvailable(new int[]{1, 3}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{2, 5}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{1, 9}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{0, 15}), ReservationStatus.DECLINE);
    }

    @Test
    public void testBookingStatus3() {
        ReservationService reservationService = new ReservationService(3);
        assertEquals(reservationService.isRoomAvailable(new int[]{1, 3}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{0, 15}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{1, 9}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{2, 5}), ReservationStatus.DECLINE);
        assertEquals(reservationService.isRoomAvailable(new int[]{4, 9}), ReservationStatus.ACCEPT);
    }

    @Test
    public void testBookingStatus4() {
        ReservationService reservationService = new ReservationService(2);
        assertEquals(reservationService.isRoomAvailable(new int[]{1, 3}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{0, 4}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{2, 3}), ReservationStatus.DECLINE);
        assertEquals(reservationService.isRoomAvailable(new int[]{5, 5}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{4, 10}), ReservationStatus.DECLINE);
        assertEquals(reservationService.isRoomAvailable(new int[]{10, 10}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{6, 7}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{8, 10}), ReservationStatus.ACCEPT);
        assertEquals(reservationService.isRoomAvailable(new int[]{8, 9}), ReservationStatus.ACCEPT);
    }

}