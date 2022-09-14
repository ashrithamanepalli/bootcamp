package com.tw.step8.bootcamp.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void shouldGiveChanceOfBothEventsOccurring() throws InvalidProbabilityException {
        Chance chanceOfCoin = Chance.createChance(0.5);
        Chance chanceOfAnotherCoin = Chance.createChance(0.5);

        Chance expected = Chance.createChance(0.25);
        Chance actual = chanceOfCoin.and(chanceOfAnotherCoin);

        assertEquals(actual,expected);
    }

    @Test
    void shouldGiveChanceOfEitherOrBothEvents() throws InvalidProbabilityException {
        Chance chanceOfCoin = Chance.createChance(0.5);
        Chance chanceOfAnotherCoin = Chance.createChance(0.5);

        Chance expected = Chance.createChance(0.75);
        Chance actual = chanceOfCoin.or(chanceOfAnotherCoin);

        assertEquals(expected,actual);
    }

    @Test
    void shouldGiveComplementOfEvent() throws InvalidProbabilityException {
        Chance chanceOfCoin = Chance.createChance(0.25);

        Chance expected = Chance.createChance(0.75);

        assertEquals(expected,chanceOfCoin.complement());
    }
}