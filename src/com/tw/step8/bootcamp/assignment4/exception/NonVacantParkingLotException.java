package com.tw.step8.bootcamp.assignment4.exception;

public class NonVacantParkingLotException extends Throwable {
    public NonVacantParkingLotException() {
        super("Non vacant parking lot");
    }
}
