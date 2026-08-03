package com.tej.librarymanagement.exception;

//  custom unchecked exception
public class InvalidBookException extends RuntimeException {
    
    public InvalidBookException(String message) {
        super(message);
    }
    
}
