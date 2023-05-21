package com.example.blogservice.model.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundResourceEx extends RuntimeException {
    public NotFoundResourceEx(String errorMessage) {
        super(errorMessage);
    }
}

