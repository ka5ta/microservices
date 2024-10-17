package com.example.productservice.exception;

public class IdNotValidException extends RuntimeException {

    public IdNotValidException() {
        super("The id is incorrect");
    }
}
