package com.tw.step8.bootcamp.assignment4;

import java.util.function.Consumer;

public class ParkingNotifier {
    private ParkingLotState state;
    private Consumer<ParkingLot> consumer;

    public ParkingNotifier() {
    }

    public void intimate(ParkingLot parkingLot) {
        this.consumer.accept(parkingLot);
    }

    public void inform(ParkingLotState state, Consumer<ParkingLot> consumer) {
        this.state = state;
        this.consumer = consumer;
    }

    public void send(ParkingLotState resultState, ParkingLot parkingLot) {
        if (state.equals(resultState)) {
            this.intimate(parkingLot);
        }
    }
}
