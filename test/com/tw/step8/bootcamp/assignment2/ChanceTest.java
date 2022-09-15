package com.tw.step8.bootcamp.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void shouldGiveChanceOfBothEventsOccurring() throws InvalidProbabilityException {
        Chance chanceOfCoin = Chance.createChance(0.5);
        Chance chanceOfAnotherCoin = Chance.createChance(1/6d);

        Chance expected = Chance.createChance(0.083);
        Chance actual = chanceOfCoin.and(chanceOfAnotherCoin);

        assertTrue(actual.isWithinDelta(expected, 0.01));
    }

    @Test
    void shouldGiveChanceOfEitherOrBothEvents() throws InvalidProbabilityException {
        Chance chanceOfCoin = Chance.createChance(0.5);
        Chance chanceOfAnotherCoin = Chance.createChance(0.25);

        Chance expected = Chance.createChance(0.625);
        Chance actual = chanceOfCoin.or(chanceOfAnotherCoin);

        assertEquals(expected,actual);
    }

    @Test
    void shouldGiveComplementOfEvent() throws InvalidProbabilityException {
        Chance chanceOfCoin = Chance.createChance(0.25);

        Chance expected = Chance.createChance(0.75);

        assertEquals(expected,chanceOfCoin.complement());
    }

    @Test
    void shouldThrowErrorWhenInvalidProbabilityIsGiven() throws InvalidProbabilityException {
        assertThrows(InvalidProbabilityException.class,()->{
            Chance.createChance(1.25);
        },"Given invalid probability 1.25");
    }
}