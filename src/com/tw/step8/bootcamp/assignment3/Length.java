package com.tw.step8.bootcamp.assignment3;

import com.tw.step8.bootcamp.assignment3.exception.InvalidLengthException;
import com.tw.step8.bootcamp.assignment3.unit.LengthUnit;

public class Length {
    private final double magnitude;
    private final LengthUnit unit;



    private Length(double magnitude, LengthUnit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public static Length createLength(double magnitude, LengthUnit lengthUnit) throws InvalidLengthException {
        if (magnitude < 0){
            throw new InvalidLengthException(magnitude);
        }
        return new Length(magnitude, lengthUnit);
    }

    public Rank compare(Length anotherLength){
        double lengthInBaseUnit = this.getMagnitudeInBaseValue();
        double anotherLengthInBaseUnit = anotherLength.getMagnitudeInBaseValue();


        int comparisonResult = Double.compare(anotherLengthInBaseUnit, lengthInBaseUnit);

        if (comparisonResult == 0){
            return Rank.EQUAL;
        }

        return comparisonResult == 1 ? Rank.GREATER : Rank.LESSER;
    }

    public Length add(Length anotherLength) throws InvalidLengthException {
        double magnitudeOfFirstLength = this.getMagnitudeInBaseValue();
        double magnitudeOfSecondLength = anotherLength.getMagnitudeInBaseValue();

        double total  = magnitudeOfFirstLength + magnitudeOfSecondLength;

        return Length.createLength(total, this.unit.getBaseUnit());
    }

    private double getMagnitudeInBaseValue(){
        return this.unit.convertToBaseValue(this.magnitude);
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
