package com.tw.step8.bootcamp.assignment3;

public class Temperature {
    private final double magnitude;
    private final TemperatureUnit unit;

    private Temperature(double magnitude, TemperatureUnit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public static Temperature createTemperature(double magnitude, TemperatureUnit unit) {
        return new Temperature(magnitude, unit);
    }

    public Rank compare(Temperature anotherTemperature){
        double temperatureInCelsius = this.convertToCelsius();
        double anotherTemperatureInCelsius = anotherTemperature.convertToCelsius();

        int comparisonResult = Double.compare(anotherTemperatureInCelsius, temperatureInCelsius);

        if (comparisonResult == 0){
            return Rank.EQUAL;
        }

        return comparisonResult == 1 ? Rank.GREATER : Rank.LESSER;
    }

    public double convertToCelsius(){
        if (this.unit.equals(TemperatureUnit.CELSIUS)){
            return this.magnitude;
        }
        return (this.magnitude - 32) * 5/9.0;
    }


}
