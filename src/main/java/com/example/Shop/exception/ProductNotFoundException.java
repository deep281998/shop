package com.example.Shop.exception;

import com.example.Shop.dtos.respodtos.ProductRespodtos;

public class ProductNotFoundException extends RuntimeException{

    public  ProductNotFoundException(String message){
        super(message);
    }
}
