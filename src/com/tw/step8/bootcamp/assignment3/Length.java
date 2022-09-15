package com.tw.step8.bootcamp.assignment3;

import java.util.HashMap;

public class Length {
    private final int magnitude;
    private final Unit unit;

    public Length(int magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public int compare(Length anotherLength){
        double lengthInBaseUnit = this.magnitude * this.unit.mm;
        double anotherLengthInBaseUnit = anotherLength.magnitude * anotherLength.unit.mm;

        return Double.compare(anotherLengthInBaseUnit, lengthInBaseUnit);
    }
}
