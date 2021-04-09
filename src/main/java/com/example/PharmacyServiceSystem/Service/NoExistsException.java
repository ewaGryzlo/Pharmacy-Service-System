package com.example.PharmacyServiceSystem.Service;

/*
This is custom exception, which throw error message if object doesn't exists in list.
 */
public class NoExistsException extends Exception{
    public NoExistsException(String errorMessage){
        super(errorMessage);
    }
}
