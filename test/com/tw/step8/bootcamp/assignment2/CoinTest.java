package com.tw.step8.bootcamp.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {
    @Test
    void shouldReturnTail(){
        Coin coin = new Coin();
        CoinFace outcome = coin.flip();
        assertTrue(CoinFace.TAILS.equals(outcome));
    }
}