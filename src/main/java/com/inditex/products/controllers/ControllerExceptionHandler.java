package com.inditex.products.controllers;

import com.inditex.products.exception.InditexException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InditexException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage inditexException(InditexException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getErrorDescription());
        return message;
    }
}
