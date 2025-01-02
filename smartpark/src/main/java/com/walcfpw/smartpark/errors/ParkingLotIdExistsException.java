package com.walcfpw.smartpark.errors;

public class ParkingLotIdExistsException extends Exception{

    public ParkingLotIdExistsException(String errorMessage) {
        super(errorMessage);
    }

}


