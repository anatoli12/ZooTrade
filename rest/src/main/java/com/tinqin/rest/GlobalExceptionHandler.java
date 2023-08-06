package com.tinqin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            NoSuchElementException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleItemNotFoundException(Exception e) {
        return e.getMessage();
    }
}
