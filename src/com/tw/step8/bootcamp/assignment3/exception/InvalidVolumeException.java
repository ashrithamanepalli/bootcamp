package com.tw.step8.bootcamp.assignment3.exception;

public class InvalidVolumeException extends Throwable {
    public InvalidVolumeException(double magnitude) {
        super(String.format("Magnitude of volume is invalid %f", magnitude));
    }
}
