package com.trainingapps.sms.reportms.dto;

import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/*
 * this is data transfer related to sales report details when the rest is hit by client  
 * this model of details is given as the response 
 * */
public class SalesReportDetails {

	@Min(1)
	private Long id;
	@NotNull
	private String startDate;
	@NotNull
	private String endDate;
	private double totalSaleAmount;
	@NotNull
	private String createdDate;
	private Map<Long, Integer> soldStocks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotalSaleAmount() {
		return totalSaleAmount;
	}

	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Map<Long, Integer> getSoldStocks() {
		return soldStocks;
	}

	public void setSoldStocks(Map<Long, Integer> soldStocks) {
		this.soldStocks = soldStocks;
	}

}
