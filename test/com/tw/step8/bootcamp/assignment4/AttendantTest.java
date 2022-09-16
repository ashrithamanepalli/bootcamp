package com.tw.step8.bootcamp.assignment4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
    @Test
    void shouldParkACarWhenVacantParkingLotsAreAvailable() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(parkingLot));
        Attendant parkingAttendant = new Attendant();
        parkingAttendant.allocateParkingLots(parkingLots);

        parkingAttendant.park(new Car(1234));

        assertArrayEquals(new SlotState[]{SlotState.OCCUPIED, SlotState.VACANT}, parkingLot.getSlots());
    }

    @Test
    void shouldModifyCurrentIdAfterCurrentLotGetFilled() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(parkingLot));
        Attendant parkingAttendant = new Attendant();
        parkingAttendant.allocateParkingLots(parkingLots);

        parkingAttendant.park(new Car(1234));
        parkingAttendant.park(new Car(14));

        ArrayList<Integer> expectedIDs = new ArrayList<>(Arrays.asList(0));

        assertEquals(1, parkingAttendant.getCurrentLotID());
        assertEquals(expectedIDs, parkingAttendant.getOccupiedLotIDs());
    }

    @Test
    void shouldAssignLotsToAssistant() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(parkingLot));
        Attendant parkingAttendant = new Attendant();
        parkingAttendant.allocateParkingLots(parkingLots);

        Assistant assistant = new Assistant();

        assertTrue(parkingAttendant.assignLotsToAssistant(assistant));

    }
}