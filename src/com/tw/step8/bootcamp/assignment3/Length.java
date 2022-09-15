package com.tw.step8.bootcamp.assignment3;

import com.tw.step8.bootcamp.assignment3.exception.InvalidLengthException;

public class Length {
    private final double magnitude;
    private final Unit unit;

    private Length(double magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public static Length createLength(double magnitude, Unit unit) throws InvalidLengthException {
        if (magnitude < 0){
            throw new InvalidLengthException(magnitude);
        }
        return new Length(magnitude, unit);
    }

    public int compare(Length anotherLength){
        double lengthInBaseUnit = this.magnitude * getBaseValue();
        double anotherLengthInBaseUnit = anotherLength.magnitude * anotherLength.getBaseValue();

        return Double.compare(anotherLengthInBaseUnit, lengthInBaseUnit);
    }

    public Length add(Length anotherLength) throws InvalidLengthException {
        double magnitudeOfFirstLength = this.getMagnitudeInBaseValue();
        double magnitudeOfSecondLength = anotherLength.getMagnitudeInBaseValue();

        double total  = magnitudeOfFirstLength + magnitudeOfSecondLength;

        return Length.createLength(total, Unit.INCH);
    }

    private double getBaseValue() {
        return this.unit.baseValue;
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
        return unit == length.unit;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(magnitude);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + unit.hashCode();
        return result;
    }
}
