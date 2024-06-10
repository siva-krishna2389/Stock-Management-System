package com.trainingapps.sms.reportms.dto;

import javax.validation.constraints.NotNull;

/*
 * data transfer object class to create report request
 * it specifies the model of the hitting rest end point
 * */
public class CreateReportRequest {

	@NotNull
	private String startDate;
	@NotNull
	private String endDate;

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

}
