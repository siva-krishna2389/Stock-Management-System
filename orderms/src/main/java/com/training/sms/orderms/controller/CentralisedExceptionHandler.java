package com.training.sms.orderms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.sms.orderms.exceptions.*;

@RestControllerAdvice
public class CentralisedExceptionHandler {

	// handle CustomerNotFound Exception
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(OrderNotFoundException.class)
	public String handleCustomerNotFound(OrderNotFoundException e) {
		return e.getMessage();
	}

//handle handleInvalidId Exception
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerIdException.class)
	public String handleInvalidId(InvalidCustomerIdException e) {
		return e.getMessage();
	}

//handle handleInvalidName Exception
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidOrderIdException.class)
	public String handleInvalidName(InvalidOrderIdException e) {
		return e.getMessage();
	}
}
