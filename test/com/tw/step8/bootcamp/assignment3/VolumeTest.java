package com.tw.step8.bootcamp.assignment3;

import com.tw.step8.bootcamp.assignment3.exception.InvalidVolumeException;
import com.tw.step8.bootcamp.assignment3.unit.VolumeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {
    @Test
    void shouldAddVolumeInGallonAndReturnInLiter() throws InvalidVolumeException {
        Volume volumeOfTank = Volume.createVolume(1, VolumeUnit.GALLON);
        Volume volumeOfBottle = Volume.createVolume(1,VolumeUnit.GALLON);

        Volume expected = Volume.createVolume(7.56, VolumeUnit.LITER);

        assertEquals(expected, volumeOfTank.add(volumeOfBottle));
    }

    @Test
    void shouldAssertEqualIfVolumesAreEqual() throws InvalidVolumeException {
        Volume volumeOfTank = Volume.createVolume(2,VolumeUnit.GALLON);
        Volume volumeOfBottle = Volume.createVolume(2,VolumeUnit.LITER);

        Rank expected = Rank.LESSER;

        assertEquals(expected, volumeOfTank.compare(volumeOfBottle));
    }

    @Test
    void shouldAssertEqualFirstVolumeIsEqualToSecondVolume() throws InvalidVolumeException {
        Volume volumeOfTank = Volume.createVolume(1,VolumeUnit.GALLON);
        Volume volumeOfBottle = Volume.createVolume(3.78,VolumeUnit.LITER);

        Rank expected = Rank.EQUAL;

        assertEquals(expected, volumeOfTank.compare(volumeOfBottle));
    }
}