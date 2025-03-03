package com.bms.bookmyshow.exceptions;

public class SeatNotAvailableException extends RuntimeException {
    public SeatNotAvailableException(String message) {
        super(message);
    }
}
