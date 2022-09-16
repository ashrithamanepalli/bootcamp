package com.tw.step8.bootcamp.assignment4;

import java.util.ArrayList;

public class Assistant {
    private ArrayList<ParkingLot> parkingLots;

    public Assistant() {
    }

    public boolean monitorLots(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        return true;
    }
}
