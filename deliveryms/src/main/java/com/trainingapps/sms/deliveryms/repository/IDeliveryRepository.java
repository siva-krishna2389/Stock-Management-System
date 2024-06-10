package com.trainingapps.sms.deliveryms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingapps.sms.deliveryms.entities.Delivery;

/*
 * Extending the Jpa repository which provides the in-built functions
 */
public interface IDeliveryRepository extends JpaRepository<Delivery, Long> {

	Delivery findDeliveryByOrderId(String orderId);

	boolean existsByOrderId(String orderId);
}
