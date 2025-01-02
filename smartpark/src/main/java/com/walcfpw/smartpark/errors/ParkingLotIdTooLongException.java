package com.walcfpw.smartpark.errors;

public class ParkingLotIdTooLongException extends Exception{

    public ParkingLotIdTooLongException(String errorMessage) {
        super(errorMessage);
    }

}