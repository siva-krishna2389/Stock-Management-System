package com.trainingapps.sms.deliveryms.exceptions;

/*
 * This exception class is extending the RuntimeException
 */
public class IdNotFoundException extends RuntimeException{
	
	public IdNotFoundException(String msg) {
		super(msg);
	}

}
