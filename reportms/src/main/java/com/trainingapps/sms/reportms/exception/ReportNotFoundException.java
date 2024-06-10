package com.trainingapps.sms.reportms.exception;

/*
 * when fetching report by id and not found then this exception is thrown
 * */
public class ReportNotFoundException extends RuntimeException {
	public ReportNotFoundException(String msg) {
		super(msg);
	}
}
