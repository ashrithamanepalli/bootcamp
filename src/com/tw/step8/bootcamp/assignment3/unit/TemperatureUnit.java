package com.tw.step8.bootcamp.assignment3.unit;

public enum TemperatureUnit  implements Unit{
    FAHRENHEIT, CELSIUS;

    @Override
    public double convertToBaseValue(double magnitude) {
        if (this.equals(TemperatureUnit.FAHRENHEIT)){
            return (magnitude - 32) * 5/9.0;
        }
        return magnitude;
    }

    public TemperatureUnit getBaseUnit() {
        return TemperatureUnit.CELSIUS;
    }
}
