package com.tw.step8.bootcamp.assignment3.exception;

import com.tw.step8.bootcamp.assignment3.Unit;

public class InvalidLengthException extends Throwable {
    public InvalidLengthException(double magnitude) {
        super(String.format("Magnitude of length is invalid %f", magnitude));
    }
}
