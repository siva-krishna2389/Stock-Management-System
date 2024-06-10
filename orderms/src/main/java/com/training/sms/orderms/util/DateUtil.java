package com.training.sms.orderms.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * this is a bean class and objects of this class in the container
 * */
@Component
public class DateUtil {

	private final String pattern = "dd-MM-yyyy";

	public String toText(LocalDate date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		return date.format(format);
	}

	public LocalDate toLocalDate(String text) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		LocalDate date = LocalDate.parse(text, format);
		return date;
	}

}
