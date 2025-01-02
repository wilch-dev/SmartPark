package com.walcfpw.smartpark.controller;

import com.walcfpw.smartpark.data.dto.ErrorDto;
import com.walcfpw.smartpark.errors.CostPerMinuteException;
import com.walcfpw.smartpark.errors.ParkingLotIdExistsException;
import com.walcfpw.smartpark.errors.ParkingLotIdTooLongException;
import com.walcfpw.smartpark.errors.TotalCapacityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ParkingLotIdExistsException.class)
    public ResponseEntity handleException(ParkingLotIdExistsException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ErrorDto.builder().errorMessage(e.getMessage()).build());
    }
    @ExceptionHandler(CostPerMinuteException.class)
    public ResponseEntity handleException(CostPerMinuteException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ErrorDto.builder().errorMessage(e.getMessage()).build());
    }
    @ExceptionHandler(TotalCapacityException.class)
    public ResponseEntity handleException(TotalCapacityException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ErrorDto.builder().errorMessage(e.getMessage()).build());
    }
    @ExceptionHandler(ParkingLotIdTooLongException.class)
    public ResponseEntity handleException(ParkingLotIdTooLongException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ErrorDto.builder().errorMessage(e.getMessage()).build());
    }

}