package com.trainingapps.sms.deliveryms.controller;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.sms.deliveryms.dto.DeliveryDetails;
import com.trainingapps.sms.deliveryms.services.DeliveryServiceImpl;

@Validated
@RequestMapping("/deliveries")
@RestController
public class DeliveryRestController {

	/*
	 * Injecting the objects of DeliveryServiceImpl class
	 */
	@Autowired
	private DeliveryServiceImpl service;

	/*
	 * Web request to create a new delivery
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public DeliveryDetails startDelivery(@RequestBody @NotBlank String requestdata) {
		return service.start(requestdata);

	}

	/*
	 * Web request to change the delivery status to dispatch
	 */
	@PutMapping("/dispatch")
	public DeliveryDetails dispatchDelivery(@RequestBody @NotBlank String requestdata) {
		return service.dispatch(requestdata);
	}

	/*
	 * Web request to change the delivery status to delivered
	 */
	@PutMapping("/deliver")
	public DeliveryDetails deliveredDelivery(@RequestBody @NotBlank String requestdata) {
		return service.delivered(requestdata);
	}

	/*
	 * Web request to get the delivery details
	 */
	@GetMapping("/byid/{id}")
	public DeliveryDetails getProduct(@NotBlank @PathVariable("id") String id) {
		return service.findDeliverDetailsByOrderId(id);
	}

}
