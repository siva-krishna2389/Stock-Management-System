package com.training.sms.orderms.exceptions;

public class InvalidOrderIdException extends RuntimeException {
	public InvalidOrderIdException(String msg) {
		super(msg);
	}
}
