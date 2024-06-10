package com.trainingapps.sms.reportms.dto;

import java.util.Map;

/*
 * this is data transfer related to order details where in rest we hit the order rest 
 * to get the order details in this specific model we need from that rest
 * */
public class OrderDetails {

	private String orderId;
	private Long customerId;
	private Map<Long, Integer> orderedStocks;
	private double amount;

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

}
