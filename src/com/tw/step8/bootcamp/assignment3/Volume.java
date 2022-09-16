package com.tw.step8.bootcamp.assignment3;

import com.tw.step8.bootcamp.assignment3.exception.InvalidVolumeException;
import com.tw.step8.bootcamp.assignment3.unit.VolumeUnit;

public class Volume {
    private final double magnitude;
    private final VolumeUnit unit;

    private Volume(double magnitude, VolumeUnit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public static Volume createVolume(double magnitude, VolumeUnit unit) throws InvalidVolumeException {
        if (magnitude < 0) {
            throw new InvalidVolumeException(magnitude);
        }
        return new Volume(magnitude, unit);
    }

    public Rank compare(Volume anotherVolume) {
        double volumeInBaseUnit = this.getMagnitudeInBaseValue();
        double anotherVolumeInBaseUnit = anotherVolume.getMagnitudeInBaseValue();

        int comparisonResult = Double.compare(anotherVolumeInBaseUnit, volumeInBaseUnit);

        if (comparisonResult == 0) {
            return Rank.EQUAL;
        }

        return comparisonResult == 1 ? Rank.GREATER : Rank.LESSER;
    }

    public Volume add(Volume anotherVolume) throws InvalidVolumeException {
        double magnitudeOfFirstVolume = this.getMagnitudeInBaseValue();
        double magnitudeOfSecondVolume = anotherVolume.getMagnitudeInBaseValue();

        double total = magnitudeOfFirstVolume + magnitudeOfSecondVolume;

        return Volume.createVolume(total, this.unit.getBaseUnit());
    }

    @Override
    public String toString() {
        return "Volume{" +
                "magnitude=" + magnitude +
                ", unit=" + unit +
                '}';
    }

    private double getMagnitudeInBaseValue() {
        return this.unit.convertToBaseValue(this.magnitude);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Volume)) return false;

        Volume volume = (Volume) o;

        if (Double.compare(volume.magnitude, magnitude) != 0) return false;
        return unit == volume.unit;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(magnitude);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
