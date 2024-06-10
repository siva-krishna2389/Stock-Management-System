package com.trainingapps.sms.deliveryms.util;

import org.springframework.stereotype.Component;

import com.trainingapps.sms.deliveryms.dto.DeliveryDetails;
import com.trainingapps.sms.deliveryms.entities.Delivery;

@Component
public class DeliveryUtil {

	public DeliveryDetails toDetails(Delivery delivery) {
		DeliveryDetails details = new DeliveryDetails();
		details.setId(delivery.getId());
		String deliveryStatus = delivery.getDeliveryStatus().name();
		details.setDeliveryStatus(deliveryStatus);
		details.setOrderId(delivery.getOrderId());
		return details;

	}
}
