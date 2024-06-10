package com.trainingapps.sms.stockms.dto;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

public class CreateStockRequest {
	@Length(min = 2, max = 20)

	private String stockname;

	@Min(1)
	private int units;

	@Min(1)
	private double price;

	public CreateStockRequest() {

	}

	public CreateStockRequest(String stockname, int units, double price) {

		this.stockname = stockname;
		this.units = units;
		this.price = price;

	}

	

	public String getStockName() {
		return stockname;
	}

	public void setStockName(String stockName) {
		this.stockname = stockName;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
