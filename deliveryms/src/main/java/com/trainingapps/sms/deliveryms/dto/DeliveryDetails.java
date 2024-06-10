package com.trainingapps.sms.deliveryms.dto;

/*
 * This class is used as data transfer objects of delivery details
 */
public class DeliveryDetails {

	private long id;

	private String deliveryStatus;

	private String orderId;

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
