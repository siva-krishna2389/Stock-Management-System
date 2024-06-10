package com.training.sms.orderms.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.training.sms.orderms.util.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.sms.orderms.dto.CreateOrderRequest;
import com.training.sms.orderms.dto.OrderDetails;
import com.training.sms.orderms.services.OrderServiceImpl;

@Validated
@RequestMapping("/orders")
@RestController
public class OrderRestController {
	/*
	 * use during integration
	 * 
	 * @Autowired private RestTemplate restTemplate;
	 */

	@Autowired
	private DateUtil dateUtil;

	@Autowired
	private OrderServiceImpl services;

	/**
	 * rest end point to add the order.
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public OrderDetails create(@RequestBody @Valid CreateOrderRequest requestdata) {
		OrderDetails response = services.create(requestdata);
		return response;
	}

	/**
	 * rest end point to fetch Order details using orderId.
	 */
	@GetMapping("/byorderid/{orderId}")
	public OrderDetails findById(@PathVariable("orderId") String orderId) {
		OrderDetails response = services.findByOrderId(orderId);
		return response;
	}

	/**
	 * Rest end point to fetch Order details using customerId.
	 */

	@GetMapping("/bycustomerid/{customerId}")
	public List<OrderDetails> ordersByCustomer(@PathVariable("customerId") Long customerId) {
		List<OrderDetails> response = services.ordersByCustomer(customerId);
		return response;
	}

	/**
	 * rest end point to fetch Order details of orders between two dates.
	 */

	@GetMapping("/between/{startDate}/{endDate}")
	public List<OrderDetails> fetchOrdersBetweenTwoDates(@PathVariable String startDate, @PathVariable String endDate) {
		LocalDate beginDate = dateUtil.toLocalDate(startDate);
		LocalDate closeDate = dateUtil.toLocalDate(endDate);
		List<OrderDetails> response = services.findOrdersBetween(beginDate, closeDate);
		return response;
	}

}
