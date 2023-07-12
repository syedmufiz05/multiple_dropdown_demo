package com.example.exception;

import lombok.Data;

@Data
public class CountryException extends Exception {
    public CountryException(String message) {
        super(message);
        getMessage();
    }
}
