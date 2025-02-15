package com.walcfpw.smartpark.controller;

import com.walcfpw.smartpark.data.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ErrorDto.builder().errorMessage(e.getMessage()).build());
    }

    // imo, would be better to have exceptions for different cases.
    // But for the sake of readability and this is just a technical assessment, opted to go for this instead.
}