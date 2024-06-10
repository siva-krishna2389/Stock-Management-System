package com.trainingapps.sms.deliveryms.services;

import com.trainingapps.sms.deliveryms.dto.DeliveryDetails;
import com.trainingapps.sms.deliveryms.entities.Delivery;

/*
 * This is a service interface for service implementation class
 */
public interface IDeliveryService {

	Delivery findByOrderId(String orderId);

	DeliveryDetails start(String orderId);// status not_dispatched

	DeliveryDetails dispatch(String orderId);// status dispatched

	DeliveryDetails delivered(String orderId);// status delivered

	DeliveryDetails findDeliverDetailsByOrderId(String orderId);

}