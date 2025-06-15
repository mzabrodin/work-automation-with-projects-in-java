package com.lab4.annotations;

public class InvalidPerson extends RuntimeException {
    public InvalidPerson(String message) {
        super(message);
    }
}
