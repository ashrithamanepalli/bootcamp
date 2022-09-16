package com.tw.step8.bootcamp.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpaceTest {
    @Test
    void shouldParkCarInVacantParkingSlot() {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.parkCar();

        assertArrayEquals(new SlotState[]{SlotState.OCCUPIED}, parkingSpace.getSlots());
    }
}