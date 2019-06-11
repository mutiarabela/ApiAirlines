package com.api.airlines.Exceptions;

public class CustomExceptionHandler extends RuntimeException{
    public CustomExceptionHandler(String message){
        super(message);
    }
}
