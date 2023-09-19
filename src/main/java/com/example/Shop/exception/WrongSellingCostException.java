package com.example.Shop.exception;

public class WrongSellingCostException extends RuntimeException{
    public WrongSellingCostException(String message){
        super(message);
    }
}
