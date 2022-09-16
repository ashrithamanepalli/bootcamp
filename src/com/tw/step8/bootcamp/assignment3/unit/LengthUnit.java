package com.tw.step8.bootcamp.assignment3.unit;

import com.tw.step8.bootcamp.assignment3.Length;

public enum LengthUnit implements Unit {
    FEET(12),INCH(1),CM(0.4),MM(0.04);

    public final double baseValue; // base value

    LengthUnit(double baseValue){
        this.baseValue = baseValue; // base value
    }

    @Override
    public double convertToBaseValue(double magnitude) {
        return this.baseValue * magnitude;
    }

    public LengthUnit getBaseUnit() {
        return LengthUnit.INCH;
    }
}
