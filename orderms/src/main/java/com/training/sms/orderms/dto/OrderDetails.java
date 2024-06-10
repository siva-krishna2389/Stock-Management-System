package com.training.sms.orderms.dto;

import java.util.Map;

public class OrderDetails {
	private String orderId;
	private Long customerId;
	private Map<Long, Integer> orderedStocks;
	private double amount;
	private String date;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Map<Long, Integer> getOrderedStocks() {
		return orderedStocks;
	}

	public void setOrderedStocks(Map<Long, Integer> orderedStocks) {
		this.orderedStocks = orderedStocks;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}