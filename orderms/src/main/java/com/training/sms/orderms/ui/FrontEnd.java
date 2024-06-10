package com.training.sms.orderms.ui;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.sms.orderms.dto.CreateOrderRequest;
import com.training.sms.orderms.dto.OrderDetails;
import com.training.sms.orderms.services.IOrderServices;

@Component
public class FrontEnd {
	@Autowired
	public IOrderServices service;

	public void start() {
		CreateOrderRequest request = new CreateOrderRequest();
		Map<Long, Integer> stockOrdered = new HashMap<>();
		stockOrdered.put(1L, 50);
		stockOrdered.put(2L, 10);
		request.setCustomerId(1L);

		OrderDetails details = service.create(request);
		display(details);
		String id = details.getOrderId();
		OrderDetails order = service.findByOrderId(id);
		display(order);

	}

	void display(OrderDetails details) {
		System.out.println(details.getCustomerId());
		System.out.println(details.getAmount());
	}
}