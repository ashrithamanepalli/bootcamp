package com.tw.step8.bootcamp.assignment3;

public enum Unit {
    FEET(12),INCH(1),CM(0.4),MM(0.04);

    public final double baseValue; // base value

    Unit(double baseValue){
        this.baseValue = baseValue; // base value
    }
}
