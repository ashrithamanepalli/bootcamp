package com.tw.step8.bootcamp.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void shouldReturnZeroWhenTemperatureInFahrenheitIsEqualWithCelsius(){
        Temperature tempOfWater = Temperature.createTemperature(100, TemperatureUnit.CELSIUS);
        Temperature tempOfMilk = Temperature.createTemperature(212, TemperatureUnit.FAHRENHEIT);

        int expected = 0;

        assertEquals(expected, tempOfWater.compare(tempOfMilk));
    }

    @Test
    void shouldReturnOneWhenTemperatureInCelsiusIsGreaterThanFahrenheit(){
        Temperature tempOfWater = Temperature.createTemperature(110, TemperatureUnit.CELSIUS);
        Temperature tempOfMilk = Temperature.createTemperature(212, TemperatureUnit.FAHRENHEIT);

        int expected = -1;

        assertEquals(expected, tempOfWater.compare(tempOfMilk));
    }
}