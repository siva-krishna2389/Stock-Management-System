package com.training.sms.orderms.exceptions;

public class InvalidCustomerIdException extends RuntimeException {
	public InvalidCustomerIdException(String msg) {
		super(msg);
	}
}
