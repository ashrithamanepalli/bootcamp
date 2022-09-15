package com.tw.step8.bootcamp.assignment3;

import com.tw.step8.bootcamp.assignment3.exception.InvalidLengthException;
import com.tw.step8.bootcamp.assignment3.unit.LengthUnit;

public class Length {
    private final double magnitude;
    private final LengthUnit lengthUnit;

    private Length(double magnitude, LengthUnit lengthUnit) {
        this.magnitude = magnitude;
        this.lengthUnit = lengthUnit;
    }

    public static Length createLength(double magnitude, LengthUnit lengthUnit) throws InvalidLengthException {
        if (magnitude < 0){
            throw new InvalidLengthException(magnitude);
        }
        return new Length(magnitude, lengthUnit);
    }

    public int compare(Length anotherLength){
        double lengthInBaseUnit = this.getMagnitudeInBaseValue();
        double anotherLengthInBaseUnit = anotherLength.getMagnitudeInBaseValue();

        return Double.compare(anotherLengthInBaseUnit, lengthInBaseUnit);
    }

    public Length add(Length anotherLength) throws InvalidLengthException {
        double magnitudeOfFirstLength = this.getMagnitudeInBaseValue();
        double magnitudeOfSecondLength = anotherLength.getMagnitudeInBaseValue();

        double total  = magnitudeOfFirstLength + magnitudeOfSecondLength;

        return Length.createLength(total, LengthUnit.INCH);
    }

    private double getBaseValue() {
        return this.lengthUnit.baseValue;
    }

    private double getMagnitudeInBaseValue(){
        return this.magnitude * this.getBaseValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;

        Length length = (Length) o;

        if (Double.compare(length.magnitude, magnitude) != 0) return false;
        return lengthUnit == length.lengthUnit;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(magnitude);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + lengthUnit.hashCode();
        return result;
    }
}
