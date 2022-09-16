package com.tw.step8.bootcamp.assignment4;

import com.tw.step8.bootcamp.assignment4.exception.NonVacantParkingLotException;

import java.util.Arrays;

public class ParkingLot {
    public static final int NOT_FOUND = -1;
    private final SlotState[] slots;
    private final ParkingNotifier notifier;
    private int vacantSlots;

    private ParkingLot(SlotState[] slots, ParkingNotifier notifier) {
        this.slots = slots;
        this.notifier = notifier;
        this.vacantSlots = this.slots.length;
    }

    public static ParkingLot createParkingLot(int numberOfSlots, ParkingNotifier notifier) {
        SlotState[] slots = new SlotState[numberOfSlots];
        Arrays.fill(slots, SlotState.VACANT);
        return new ParkingLot(slots, notifier);
    }

    public int findFirstVacantSlot() {
        for (int index = 0; index < slots.length; index++) {
            if (slots[index] == SlotState.VACANT) {
                return index;
            }
        }
        return NOT_FOUND;
    }

    public void park(Car car) throws NonVacantParkingLotException {
        if (vacantSlots > 0) {
            occupySlot();
        }
        if (vacantSlots / slots.length > 0.8) {
            sendNotification(ParkingLotState.EIGHTY_PERCENT_FILLED);
        }
        if (vacantSlots <= 0) {
            throw new NonVacantParkingLotException();
        }
    }

    private void occupySlot() {
        int slotIndex = findFirstVacantSlot();
        slots[slotIndex] = SlotState.OCCUPIED;
        vacantSlots--;
    }

    public SlotState[] getSlots() {
        return slots;
    }

    public void sendNotification(ParkingLotState state) {
        notifier.send(state, this);
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "slots=" + Arrays.toString(slots) +
                ", vacantSlots=" + vacantSlots +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLot)) return false;

        ParkingLot that = (ParkingLot) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(slots, that.slots);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(slots);
    }
}
