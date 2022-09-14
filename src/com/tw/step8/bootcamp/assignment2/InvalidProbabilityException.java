package com.tw.step8.bootcamp.assignment2;

public class InvalidProbabilityException extends Throwable {
    public InvalidProbabilityException(double probability) {
        super("Given invalid probability " + probability);
    }
}
