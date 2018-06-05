package com.marshmallow.oilspilcleaner.exception;

public class ErrorResponse {

    String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
