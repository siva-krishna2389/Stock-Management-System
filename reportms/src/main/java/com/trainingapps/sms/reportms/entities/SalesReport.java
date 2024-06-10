package com.trainingapps.sms.reportms.entities;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * It represents entity class and a bean class and related to database
 * */
@Table(name = "salesreport")
@Entity
public class SalesReport {

	@GeneratedValue
	@Id
	private Long id;
	private double totalSaleAmount;
	private LocalDate createdDate;
	private LocalDate startDate;
	private LocalDate endDate;

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Long, Integer> soldStocks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getTotalSaleAmount() {
		return totalSaleAmount;
	}

	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}

	public Map<Long, Integer> getSoldStocks() {
		return soldStocks;
	}

	public void setSoldStocks(Map<Long, Integer> soldStocks) {
		this.soldStocks = soldStocks;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesReport other = (SalesReport) obj;
		return id == other.id;
	}

}
