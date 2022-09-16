package com.tw.step8.bootcamp.assignment4;

import com.tw.step8.bootcamp.assignment4.exception.NonVacantParkingLotException;

import java.util.Arrays;

public class ParkingLot {
    public static final int NOT_FOUND = -1;
    private final SlotState[] slots;
    private int vacantSlots;

    private ParkingLot(SlotState[] slots) {
        this.slots = slots;
        this.vacantSlots = this.slots.length;
    }

    public static ParkingLot createParkingLot(int numberOfSlots) {
        SlotState[] slots = new SlotState[numberOfSlots];
        Arrays.fill(slots, SlotState.VACANT);
        return new ParkingLot(slots);
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
