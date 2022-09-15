package com.tw.step8.bootcamp.assignment3;

public enum Unit {
    FEET(300),INCH(25),CM(10),MM(1);

    public final double mm;

    Unit(double mm){
        this.mm = mm;
    }
}
