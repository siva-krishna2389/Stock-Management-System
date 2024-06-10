package com.trainingapps.sms.stockms.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.trainingapps.sms.stockms.exception.StockNotFoundException;

import org.springframework.http.HttpStatus;

public class CentralizedExceptionHandler {
	/**
	 * handles StockNotFoundException
	 */

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(StockNotFoundException.class)
	public String handleStockNotFound(StockNotFoundException e) {
		return e.getMessage();
	}

}
