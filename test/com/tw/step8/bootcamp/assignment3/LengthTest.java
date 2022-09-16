package com.tw.step8.bootcamp.assignment3;

import com.tw.step8.bootcamp.assignment3.exception.InvalidLengthException;
import com.tw.step8.bootcamp.assignment3.unit.LengthUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void shouldAssertEqualIfLengthGivenInFeetAndInchesAreEqual() throws InvalidLengthException {
        Length rameshHeight = Length.createLength(3, LengthUnit.FEET);
        Length sureshHeight = Length.createLength(36, LengthUnit.INCH);

        Rank expected = Rank.EQUAL;

        assertEquals(expected, rameshHeight.compare(sureshHeight));
    }

    @Test
    void shouldAssertGreaterIfLengthGivenInInchIsGreaterThanLenghtInCm() throws InvalidLengthException {
        Length rameshHeight = Length.createLength(5, LengthUnit.CM);
        Length sureshHeight = Length.createLength(3, LengthUnit.INCH);

        Rank expected = Rank.GREATER;

        assertEquals(expected, rameshHeight.compare(sureshHeight));
    }

    @Test
    void shouldCompareLengthGivenInInchAndMm() throws InvalidLengthException {
        Length rameshHeight = Length.createLength(4, LengthUnit.INCH);
        Length sureshHeight = Length.createLength(99, LengthUnit.MM);

        Rank expected = Rank.LESSER;

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