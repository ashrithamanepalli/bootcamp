package com.tw.step8.bootcamp.assignment4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class ManagerTest {

    @Test
    void assignParkingLotToAttendant() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2, new ParkingNotifier());
        ArrayList<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(parkingLot));
        Attendant parkingAttendant = new Attendant();
        Manager manager = new Manager(parkingLots, new ParkingNotifier());

        manager.assignParkingLotToAttendant(parkingAttendant);
    }
}