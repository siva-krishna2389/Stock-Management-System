package com.training.sms.orderms.entities;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "orders")
@Entity
public class CreatedOrder

{
	@Id
	private String orderId;

	private Long customerId;
	private LocalDate createdDate;

	// stockId and number of Units of the stock
	@ElementCollection(fetch = FetchType.EAGER)
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

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreatedOrder other = (CreatedOrder) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else {
			if (!orderId.equals(other.orderId))
				return false;
		}
		return true;
	}

}