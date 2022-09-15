package com.tw.step8.bootcamp.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void shouldCompareLengthGivenInFeetAndInches(){
        Length rameshHeight = new Length(3, Unit.FEET);
        Length sureshHeight = new Length(36, Unit.INCH);

        int expected = 0;

        assertEquals(expected, rameshHeight.compare(sureshHeight));
    }

    @Test
    void shouldCompareLengthGivenInInchesAndCms(){
        Length rameshHeight = new Length(5, Unit.CM);
        Length sureshHeight = new Length(3, Unit.INCH);

        int expected = 1;

        assertEquals(expected, rameshHeight.compare(sureshHeight));
    }
}