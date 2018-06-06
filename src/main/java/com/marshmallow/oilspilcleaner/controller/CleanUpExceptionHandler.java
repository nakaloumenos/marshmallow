package com.marshmallow.oilspilcleaner.controller;

import com.marshmallow.oilspilcleaner.exception.ErrorResponse;
import com.marshmallow.oilspilcleaner.exception.OutOfBoundsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CleanUpExceptionHandler extends ResponseEntityExceptionHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(CleanUpExceptionHandler.class);

    @ExceptionHandler(OutOfBoundsException.class)
    public ResponseEntity handleOutOfBounsException(OutOfBoundsException exception) {
        String errorMessage = exception.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(errorMessage);
        LOGGER.debug("Returning 400 Bad Request");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = "Input of X and Y coordinates must be a List of exactly 2 Integers";
        ErrorResponse errorResponse = new ErrorResponse(errorMessage);
        LOGGER.debug("Returning 400 Bad Request");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
