package com.training.sms.orderms.exceptions;

public class InvalidDateException extends RuntimeException {
	public InvalidDateException(String msg) {
		super(msg);
	}
}