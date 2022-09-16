package com.tw.step8.bootcamp.assignment4;

import java.util.ArrayList;

public class Manager {
    private final ArrayList<ParkingLot> parkingLots;

    public Manager(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    void assignParkingLotToAttendant(Attendant attendant) {
        attendant.allocateParkingLots(parkingLots);
    }

}
