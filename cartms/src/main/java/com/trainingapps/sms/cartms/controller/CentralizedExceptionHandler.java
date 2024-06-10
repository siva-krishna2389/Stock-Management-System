package com.trainingapps.sms.cartms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trainingapps.sms.cartms.exception.CartNotFoundException;
import com.trainingapps.sms.cartms.exception.CustomerNotFoundException;
import com.trainingapps.sms.cartms.exception.InvalidCartIdException;
import com.trainingapps.sms.cartms.exception.InvalidCustomerIdException;
import com.trainingapps.sms.cartms.exception.InvalidUnitCountException;


// centralized exception handler used to handle custom exceptions

@RestControllerAdvice
public class CentralizedExceptionHandler {

    
//  Handles CartNotFoundException
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CartNotFoundException.class)
    public String handleCartNotFound(CartNotFoundException e) {
        return e.getMessage();
    }

//  Handles CustomerNotFoundException
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleCustomerNotFound(CustomerNotFoundException e) {
        return e.getMessage();
    }
    
//  Handles InvalidCartIdException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCartIdException.class)
    public String handleInvalidCartId(InvalidCartIdException e){
        return e.getMessage();
    }

//  Handles InvalidCustomerIdException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCustomerIdException.class)
    public String handleInvalidCustomerId(InvalidCustomerIdException e){
        return e.getMessage();
    }

//  Handles InvalidUnitCountException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidUnitCountException.class)
    public String handleInvalidUnitCount(InvalidUnitCountException e){
        return e.getMessage();
    }


}
