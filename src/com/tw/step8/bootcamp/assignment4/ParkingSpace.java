package com.tw.step8.bootcamp.assignment4;

import java.util.Arrays;

public class ParkingSpace {
    private final SlotState[] slots;

    public ParkingSpace() {
        this.slots = new SlotState[1];
    }

    public void parkCar() {
        slots[0] = SlotState.OCCUPIED;
    }

    public SlotState[] getSlots() {
        return slots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingSpace)) return false;

        ParkingSpace that = (ParkingSpace) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(slots, that.slots);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(slots);
    }
}
