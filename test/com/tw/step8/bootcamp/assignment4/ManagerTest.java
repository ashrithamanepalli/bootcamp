package com.tw.step8.bootcamp.assignment4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ManagerTest {

    @Test
    void assignParkingLotToAttendant() {
        ParkingNotifier notifier = new ParkingNotifier();
        ParkingLot parkingLot = ParkingLot.createParkingLot(2, notifier);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(parkingLot));
        Attendant mockedAttendant = mock(Attendant.class);
        Manager manager = Manager.createManager(parkingLots, notifier);

        manager.assignParkingLotToAttendant(mockedAttendant);

        verify(mockedAttendant).allocateParkingLots(any());
    }

    @Test
    void shouldRemoveParkingLotFromLotsForTrainee() {
        ParkingNotifier notifier = new ParkingNotifier();
        ParkingLot firstLot = ParkingLot.createParkingLot(2, notifier);
        ParkingLot secondLot = ParkingLot.createParkingLot(2, notifier);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(firstLot, secondLot));
        Attendant attendant = new Attendant();
        Manager manager = Manager.createManager(parkingLots, notifier);

        manager.assignParkingLotToAttendant(attendant);

        attendant.park(new Car(12));
        attendant.park(new Car(34));

        assertEquals(new ArrayList(Arrays.asList(secondLot)), manager.getAvailableLotsForTrainee());
    }
}