package com.training.sms.orderms.dto;

import java.util.Map;

public class CreateOrderRequest {
	private Long customerId;
	private Map<String, Integer> orderedStocks;

	public Map<String, Integer> getOrderedStocks() {
		return orderedStocks;
	}

	public void setOrderedStocks(Map<String, Integer> orderedStocks) {
		this.orderedStocks = orderedStocks;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
