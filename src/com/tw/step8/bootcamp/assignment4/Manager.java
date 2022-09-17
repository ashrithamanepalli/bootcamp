package com.tw.step8.bootcamp.assignment4;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Manager {
    private final ArrayList<ParkingLot> parkingLots;
    private final ParkingNotifier notifier;
    private ArrayList<ParkingLot> availableLotsForTrainee;


    private Manager(ArrayList<ParkingLot> parkingLots, ParkingNotifier notifier) {
        this.notifier = notifier;
        this.parkingLots = parkingLots;
        this.availableLotsForTrainee = parkingLots;
    }

    public static Manager createManager(ArrayList<ParkingLot> parkingLots, ParkingNotifier notifier) {
        Manager manager = new Manager(parkingLots, notifier);
        manager.notifyMe(ParkingLotState.EIGHTY_PERCENT_FILLED);
        return manager;
    }

    public void assignParkingLotToAttendant(Attendant attendant) {
        attendant.allocateParkingLots(parkingLots);
    }

    private void disable(ParkingLot parkingLot) {
        this.availableLotsForTrainee.remove(parkingLot);
    }

    public void notifyMe(ParkingLotState state) {
        notifier.<ParkingLot>inform(state, new Consumer<ParkingLot>() {
            @Override
            public void accept(ParkingLot parkingLot) {
                Manager.this.disable(parkingLot);
            }
        });
    }

    public ArrayList<ParkingLot> getAvailableLotsForTrainee() {
        return availableLotsForTrainee;
    }
}
