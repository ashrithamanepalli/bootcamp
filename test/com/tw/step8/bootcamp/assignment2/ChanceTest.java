package com.tw.step8.bootcamp.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void shouldGiveChanceOfBothEventsOccurring() {
        Chance chanceOfCoin = new Chance(0.5);
        Chance chanceOfAnotherCoin = new Chance(0.5);

        Chance expected = new Chance(0.25);
        Chance actual = chanceOfCoin.and(chanceOfAnotherCoin);

        assertEquals(actual,expected);
    }

    @Test
    void shouldGiveChanceOfEitherOrBothEvents() {
        Chance chanceOfCoin = new Chance(0.5);
        Chance chanceOfAnotherCoin = new Chance(0.5);

        Chance expected = new Chance(0.75);
        Chance actual = chanceOfCoin.or(chanceOfAnotherCoin);

        assertEquals(expected,actual);
    }

    @Test
    void shouldGiveComplementOfEvent(){
        Chance chanceOfCoin = new Chance(0.25);

        Chance expected = new Chance(0.75);

        assertEquals(expected,chanceOfCoin.complement());
    }
}