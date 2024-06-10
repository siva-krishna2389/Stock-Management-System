package com.trainingapps.sms.reportms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.sms.reportms.dto.CreateReportRequest;
import com.trainingapps.sms.reportms.dto.SalesReportDetails;
import com.trainingapps.sms.reportms.services.SalesReportServiceImpl;

/*
 * This class is controller and bean class and  
 * mapping type of uri /products is concatenated to all methods
 */
@Validated
@RequestMapping("/salesreports")
@RestController
public class SalesReportController {

	@Autowired
	private SalesReportServiceImpl service;

	/*
	 * create the sales report details for a period of start and end date mentioned
	 * effective uri is /products/add
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/create/report")
	public SalesReportDetails createReport(@RequestBody @Valid CreateReportRequest requestdata) {
		return service.create(requestdata);
	}

	/*
	 * fetch sales report using the report id effective uri is /products/add
	 */
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/by/id/{id}")
	public SalesReportDetails findSalesReportById(@PathVariable("id") @Valid Long reportId) {
		return service.findReportDetailsById(reportId);
	}

}
