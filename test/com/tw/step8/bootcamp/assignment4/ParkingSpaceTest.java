package com.tw.step8.bootcamp.assignment4;

import com.tw.step8.bootcamp.assignment4.exception.NonVacantParkingLotException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpaceTest {
    @Test
    void shouldParkCarInVacantParkingSlot() throws NonVacantParkingLotException {
        ParkingLot parkingSpace = ParkingLot.createParkingLot(2);
        parkingSpace.park(new Car(1234));

        assertArrayEquals(new SlotState[]{SlotState.OCCUPIED, SlotState.VACANT}, parkingSpace.getSlots());
    }

    @Test
    void shouldThrowNonVacantParkingLotException() throws NonVacantParkingLotException {
        ParkingLot parkingSpace = ParkingLot.createParkingLot(2);
        parkingSpace.park(new Car(1234));

        assertThrows(NonVacantParkingLotException.class, () -> parkingSpace.park(new Car(34)));
    }
}