package com.tw.step8.bootcamp.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
    @Test
    void shouldParkACarWhenVacantParkingLotsAreAvailable() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        ParkingLot[] parkingLots = {parkingLot};
        Attendant parkingAttendant = new Attendant(parkingLots);
        parkingAttendant.park(new Car(1234));

        assertArrayEquals(new SlotState[]{SlotState.OCCUPIED, SlotState.VACANT}, parkingLot.getSlots());
    }
}