package com.tw.step8.bootcamp.assignment4;

import com.tw.step8.bootcamp.assignment3.Length;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class Manager {
    private final ArrayList<ParkingLot> parkingLots;
    private final ParkingNotifier notifier;
    private ArrayList<ParkingLot> availableLotsForTrainee;

    public Manager(ArrayList<ParkingLot> parkingLots, ParkingNotifier notifier) {
        this.notifier = notifier;
        this.parkingLots = parkingLots;
    }

    public void assignParkingLotToAttendant(Attendant attendant) {
        attendant.allocateParkingLots(parkingLots);
    }

    private void disable(ParkingLot parkingLot) {
        this.availableLotsForTrainee.remove(parkingLot);
    }

    public void notifyMe() {
        notifier.<ParkingLot>inform(ParkingLotState.EIGHTY_PERCENT_FILLED, new Consumer<ParkingLot>() {
            @Override
            public void accept(ParkingLot parkingLot) {
                Manager.this.disable(parkingLot);
            }
        });
    }


}
