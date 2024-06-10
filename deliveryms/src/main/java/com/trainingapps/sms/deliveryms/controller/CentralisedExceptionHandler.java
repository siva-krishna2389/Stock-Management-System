package com.trainingapps.sms.deliveryms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trainingapps.sms.deliveryms.exceptions.IdNotFoundException;
import com.trainingapps.sms.deliveryms.exceptions.InvalidIdException;

@RestControllerAdvice
public class CentralisedExceptionHandler {
	
	/*
	 * handle exception when id is not in database
	 */
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public String handleIdNotFound(IdNotFoundException e) {
		return e.getMessage();
	}
	
	
	/*
	 * handle exception when entered id is wrong
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidIdException.class)
	public String handleInvalidId(InvalidIdException e) {
		return e.getMessage();
	}
	

}
