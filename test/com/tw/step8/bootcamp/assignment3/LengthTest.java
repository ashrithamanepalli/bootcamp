package com.tw.step8.bootcamp.assignment3;

import com.tw.step8.bootcamp.assignment3.exception.InvalidLengthException;
import com.tw.step8.bootcamp.assignment3.unit.LengthUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void shouldCompareLengthGivenInFeetAndInches() throws InvalidLengthException {
        Length rameshHeight = Length.createLength(3, LengthUnit.FEET);
        Length sureshHeight = Length.createLength(36, LengthUnit.INCH);

        int expected = 0;

        assertEquals(expected, rameshHeight.compare(sureshHeight));
    }

    @Test
    void shouldCompareLengthGivenInInchAndCm() throws InvalidLengthException {
        Length rameshHeight = Length.createLength(5, LengthUnit.CM);
        Length sureshHeight = Length.createLength(3, LengthUnit.INCH);

        int expected = 1;

        assertEquals(expected, rameshHeight.compare(sureshHeight));
    }

    @Test
    void shouldCompareLengthGivenInInchAndMm() throws InvalidLengthException {
        Length rameshHeight = Length.createLength(4, LengthUnit.INCH);
        Length sureshHeight = Length.createLength(99, LengthUnit.MM);

        int expected = -1;

        assertEquals(expected, rameshHeight.compare(sureshHeight));
    }

    @Test
    void shouldThrowExceptionIfMagnitudeOfLengthIsNegative(){
        assertThrows(InvalidLengthException.class,()->{
            Length.createLength(-1, LengthUnit.INCH);
        }, "Magnitude of length is invalid -1");
    }

    @Test
    void shouldAddTwoLengthHavingUnitInInches() throws InvalidLengthException {
        Length rameshHeight = Length.createLength(4, LengthUnit.INCH);
        Length sureshHeight = Length.createLength(2, LengthUnit.INCH);

        Length expected = Length.createLength(6, LengthUnit.INCH);

        assertEquals(expected, rameshHeight.add(sureshHeight));
    }
    @Test
    void shouldAddLengthOfCentiMeterAndInch() throws InvalidLengthException {
        Length rameshHeight = Length.createLength(2.5, LengthUnit.CM);
        Length sureshHeight = Length.createLength(2, LengthUnit.INCH);

        Length expected = Length.createLength(3, LengthUnit.INCH);

        assertEquals(expected, rameshHeight.add(sureshHeight));
    }

}