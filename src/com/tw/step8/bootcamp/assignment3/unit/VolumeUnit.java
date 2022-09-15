package com.tw.step8.bootcamp.assignment3.unit;

public enum VolumeUnit {
    GALLON(3.78),LITER(1);

    public final double baseValue;

    VolumeUnit(double baseValue) {
        this.baseValue = baseValue;
    }
}
