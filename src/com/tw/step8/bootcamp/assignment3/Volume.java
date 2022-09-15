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
        if (magnitude < 0){
            throw new InvalidVolumeException(magnitude);
        }
        return new Volume(magnitude, unit);
    }

    public int compare(Volume anotherVolume){
        double volumeInBaseUnit = this.getMagnitudeInBaseValue();
        double anotherVolumeInBaseUnit = anotherVolume.getMagnitudeInBaseValue();

        return Double.compare(anotherVolumeInBaseUnit, volumeInBaseUnit);
    }

    public Volume add(Volume anotherVolume) throws InvalidVolumeException {
        double magnitudeOfFirstVolume = this.getMagnitudeInBaseValue();
        double magnitudeOfSecondVolume = anotherVolume.getMagnitudeInBaseValue();

        double total  = magnitudeOfFirstVolume + magnitudeOfSecondVolume;

        return Volume.createVolume(total, VolumeUnit.LITER);
    }

    @Override
    public String toString() {
        return "Volume{" +
                "magnitude=" + magnitude +
                ", unit=" + unit +
                '}';
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