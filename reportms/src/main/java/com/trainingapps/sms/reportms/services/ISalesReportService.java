package com.trainingapps.sms.reportms.services;


import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.sms.reportms.dto.CreateReportRequest;
import com.trainingapps.sms.reportms.dto.SalesReportDetails;
import com.trainingapps.sms.reportms.entities.SalesReport;

/*
 * interface related to service layer and all the method signatures are given
 * Validation on service layer is also done using spring framework validations
 * */
@Validated
public interface ISalesReportService {

	SalesReport findReportById(@Min(1) Long reportId);

	SalesReportDetails create(CreateReportRequest request);

	SalesReportDetails findReportDetailsById(@Min(1) Long reportId);
}
