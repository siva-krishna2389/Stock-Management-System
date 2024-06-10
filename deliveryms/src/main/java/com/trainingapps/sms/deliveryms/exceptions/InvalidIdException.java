package com.trainingapps.sms.deliveryms.exceptions;

/*
 * This exception class is extending the RuntimeException
 */
public class InvalidIdException extends RuntimeException {
	
	public InvalidIdException(String msg) {
		super(msg);
	}

}
