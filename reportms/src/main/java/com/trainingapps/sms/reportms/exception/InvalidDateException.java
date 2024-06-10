package com.trainingapps.sms.reportms.exception;

/*
 * when date entered is lesser than today or end date is less than start date throws exception
 * */
public class InvalidDateException extends RuntimeException {
	public InvalidDateException(String msg) {
		super(msg);
	}
}
