package com.tw.step8.bootcamp.assignment3.unit;

public enum VolumeUnit implements Unit{
    GALLON(3.78),LITER(1);

    public final double baseValue;

    VolumeUnit(double baseValue) {
        this.baseValue = baseValue;
    }

    @Override
    public double convertToBaseValue(double magnitude) {
        return this.baseValue * magnitude;
    }

    public VolumeUnit getBaseUnit() {
        return VolumeUnit.LITER;
    }
}
