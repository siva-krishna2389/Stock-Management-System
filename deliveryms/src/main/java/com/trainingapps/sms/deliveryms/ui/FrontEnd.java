package com.trainingapps.sms.deliveryms.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingapps.sms.deliveryms.dto.DeliveryDetails;
import com.trainingapps.sms.deliveryms.entities.Delivery;
import com.trainingapps.sms.deliveryms.exceptions.InvalidIdException;
import com.trainingapps.sms.deliveryms.services.DeliveryServiceImpl;

@Component
public class FrontEnd {
	@Autowired
	private DeliveryServiceImpl service;
	
	private Logger Log = LoggerFactory.getLogger(FrontEnd.class);


	public void ui() {
		try {
			String orderId = "aa1323bb87";
			DeliveryDetails d1 = service.start(orderId);
			display(d1);
			DeliveryDetails d2 = service.dispatch(orderId);
			display(d2);
			DeliveryDetails d3 = service.delivered(orderId);
			display(d3);
			Delivery delivery = service.findByOrderId(orderId);
			display(delivery);
		} catch (InvalidIdException e) {
			Log.info(e.getMessage());
		} catch (NumberFormatException e) {
			Log.info("Invalid OrderId");
		}

	}

	void display(DeliveryDetails d3) {
		Log.info("Order Id : "+d3.getId());
	}

	void display(Delivery delivery) {
		Log.info(delivery.getId() + " - " + delivery.getDeliveryDate() + " - " + delivery.getDeliveryStatus());
	}

}