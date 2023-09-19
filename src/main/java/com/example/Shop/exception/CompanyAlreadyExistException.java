package com.example.Shop.exception;

public class CompanyAlreadyExistException extends RuntimeException{

    public CompanyAlreadyExistException(String alreadyExist) {
        super(alreadyExist);
    }
}
