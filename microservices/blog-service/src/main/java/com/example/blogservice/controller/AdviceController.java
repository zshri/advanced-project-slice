package com.example.blogservice.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
//    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "This should be application specific";
//        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
//    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
//        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//    }

}


