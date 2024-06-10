package com.trainingapps.sms.reportms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trainingapps.sms.reportms.exception.InvalidDateException;
import com.trainingapps.sms.reportms.exception.ReportNotFoundException;

/*
 * This class handles the exceptions that may occur when using the rest services
 * */
@RestControllerAdvice
public class CentralizedExceptionHandler {

	/*
	 * when report is not found by fetching using the report id exception is thrown
	 * as report is not found as report not exist in database
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ReportNotFoundException.class)
	public String handleReportNotFound(ReportNotFoundException e) {
		return e.getMessage();
	}

	/*
	 * when entered date does not the validations like end date should be grater
	 * than start date the invalid date exception is thrown and handeled
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidDateException.class)
	public String handleInvalidDate(InvalidDateException e) {
		return e.getMessage();
	}

}
