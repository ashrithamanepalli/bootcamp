package com.tw.step8.bootcamp.assignment4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void assignParkingLotToAttendant() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(parkingLot));
        Attendant parkingAttendant = new Attendant();
        Manager manager = new Manager(parkingLots);

        manager.assignParkingLotToAttendant(parkingAttendant);
    }
}