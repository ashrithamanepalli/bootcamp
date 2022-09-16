package com.tw.step8.bootcamp.assignment3;

import com.tw.step8.bootcamp.assignment3.unit.TemperatureUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void shouldAssertEqualWhenTemperatureInFahrenheitIsEqualWithCelsius(){
        Temperature tempOfWater = Temperature.createTemperature(100, TemperatureUnit.CELSIUS);
        Temperature tempOfMilk = Temperature.createTemperature(212, TemperatureUnit.FAHRENHEIT);

        Rank expected = Rank.EQUAL;

        assertEquals(expected, tempOfWater.compare(tempOfMilk));
    }

    @Test
    void shouldAssertLesserWhenTemperatureInCelsiusIsLesserThanFahrenheit(){
        Temperature tempOfWater = Temperature.createTemperature(110, TemperatureUnit.CELSIUS);
        Temperature tempOfMilk = Temperature.createTemperature(212, TemperatureUnit.FAHRENHEIT);

        Rank expected = Rank.LESSER;

        assertEquals(expected, tempOfWater.compare(tempOfMilk));
    }

    @Test
    void shouldAssertGreaterWhenTemperatureInCelsiusIsGreaterThanFahrenheit(){
        Temperature tempOfWater = Temperature.createTemperature(100, TemperatureUnit.CELSIUS);
        Temperature tempOfMilk = Temperature.createTemperature(220, TemperatureUnit.FAHRENHEIT);

        Rank expected = Rank.GREATER;

        assertEquals(expected, tempOfWater.compare(tempOfMilk));
    }
}