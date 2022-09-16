package com.tw.step8.bootcamp.assignment4;

import com.tw.step8.bootcamp.assignment4.exception.NonVacantParkingLotException;

import java.util.ArrayList;

public class Attendant {
    private final ParkingLot[] parkingLots;
    private final ArrayList<Integer> occupiedLotIDs;
    private int currentLotID;

    public Attendant(ParkingLot[] parkingLots) {
        this.parkingLots = parkingLots;
        this.occupiedLotIDs = new ArrayList<Integer>();
        this.currentLotID = 0;
    }

    void assignLotsToAssistant(Assistant assistant) {
        assistant.monitorLots(parkingLots);
    }

    public void park(Car car) {
        try {
            parkingLots[currentLotID].park(car);
        } catch (NonVacantParkingLotException e) {
            occupiedLotIDs.add(currentLotID);
            currentLotID++;
        }
    }
}

