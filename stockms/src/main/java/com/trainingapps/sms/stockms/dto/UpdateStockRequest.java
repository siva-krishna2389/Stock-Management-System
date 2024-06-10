package com.trainingapps.sms.stockms.dto;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

public class UpdateStockRequest {
	@Min(1)
	private Long id;
	
	@Length(min = 2, max = 20)
	private String stockname;
	
	@Min(1)
	private int units;
	
	@Min(1)
	private double price;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
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
