package com.tw.step8.bootcamp.assignment4;

import com.tw.step8.bootcamp.assignment4.exception.NonVacantParkingLotException;

import java.util.ArrayList;

public class Attendant {
    private ArrayList<ParkingLot> parkingLots;
    private ArrayList<Integer> occupiedLotIDs;
    private int currentLotID;

    public Attendant() {
        this.parkingLots = new ArrayList<>();
        this.occupiedLotIDs = new ArrayList<>();
        this.currentLotID = 0;
    }

    public void allocateParkingLots(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }


    public boolean assignLotsToAssistant(Assistant assistant) {
        return assistant.monitorLots(parkingLots);
    }

    public void park(Car car) {
        try {
            parkingLots.get(currentLotID).park(car);
        } catch (NonVacantParkingLotException e) {
            occupiedLotIDs.add(currentLotID);
            currentLotID++;
        }
    }

    protected int getCurrentLotID() {
        return currentLotID;
    }

    protected ArrayList<Integer> getOccupiedLotIDs() {
        return occupiedLotIDs;
    }
}

