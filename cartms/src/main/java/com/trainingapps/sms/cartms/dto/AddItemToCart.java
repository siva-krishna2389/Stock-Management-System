package com.trainingapps.sms.cartms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddItemToCart {

	@Min(1)
	@NotNull
	private Long customerId;
	private Long stockId;
	private int units;

	public Long getCustomerId() {return customerId;}

	public void setCustomerId(Long customerId) {this.customerId = customerId;}

	public Long getStockId() {return stockId;}

	public void setStockId(Long stockId) {this.stockId = stockId;}

	public int getUnits() {	return units;}

	public void setUnits(int units) {this.units = units;}

}
