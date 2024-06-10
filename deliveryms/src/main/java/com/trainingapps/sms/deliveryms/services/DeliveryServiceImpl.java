package com.trainingapps.sms.deliveryms.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainingapps.sms.deliveryms.constants.DeliveryStatus;
import com.trainingapps.sms.deliveryms.dto.DeliveryDetails;
import com.trainingapps.sms.deliveryms.entities.Delivery;
import com.trainingapps.sms.deliveryms.exceptions.IdNotFoundException;
import com.trainingapps.sms.deliveryms.exceptions.InvalidIdException;
import com.trainingapps.sms.deliveryms.repository.IDeliveryRepository;
import com.trainingapps.sms.deliveryms.util.DeliveryUtil;

/*
 * This is a service class and this class is related to service layer
 * this is bean class so objects are stored in Servlet container
 * this is implementation class of product service interface
 * */
@Transactional
@Service
public class DeliveryServiceImpl implements IDeliveryService {

	/*
	 * Autowired marks a constructor, field, setter method, or config method as to
	 * be autowired by Spring's dependency injection facilities.
	 */
	@Autowired //
	private DeliveryUtil deliveryUtil;

	@Autowired
	private IDeliveryRepository dao;

	/*
	 * This method starts a new delivery Returns the delivery status as
	 * NotDispatched
	 */
	@Override
	public DeliveryDetails start(String orderId) {
		Delivery delivery = new Delivery();
		delivery.setOrderId(orderId);
		DeliveryStatus status = DeliveryStatus.NOTDISPATCHED;
		delivery.setDeliveryStatus(status);
		Delivery saved = dao.save(delivery);
		return deliveryUtil.toDetails(saved);
	}

	/*
	 * Changes the status to Dispatched
	 */
	@Override
	public DeliveryDetails dispatch(String orderId) {
		Delivery delivery = findByOrderId(orderId);
		delivery.setOrderId(orderId);
		delivery.setDeliveryStatus(DeliveryStatus.DISPATCHED);
		delivery = dao.save(delivery);
		return deliveryUtil.toDetails(delivery);

	}

	/*
	 * Changes the status to Delivered
	 */

	@Override
	public DeliveryDetails delivered(String orderId) {
		Delivery delivery = findByOrderId(orderId);
		delivery.setOrderId(orderId);
		delivery.setDeliveryStatus(DeliveryStatus.DELIVERED);
		LocalDateTime now = LocalDateTime.now();
		delivery.setDeliveryDate(now);
		delivery = dao.save(delivery);
		return deliveryUtil.toDetails(delivery);
	}

	/*
	 * If the entered order id doesn't exist, it throws the NumberFormatException
	 * Returns Invalid Order Id
	 */

	@Override
	public Delivery findByOrderId(String orderId) {
		boolean exists = dao.existsByOrderId(orderId);
		if (!exists) {
			throw new IdNotFoundException("Invalid Order Id");
		}

		return dao.findDeliveryByOrderId(orderId);
	}

	/*
	 * Returns the delivery details when order id is entered
	 */
	@Override
	public DeliveryDetails findDeliverDetailsByOrderId(String orderId) {
		Delivery delivery = findByOrderId(orderId);
		return deliveryUtil.toDetails(delivery);
	}

	/*
	 * Validates the id Returns InvalidIdException if id is less than or equal to 0
	 */

	void validateId(long id) {
		if (id <= 0) {
			throw new InvalidIdException("entered id is invalid");
		}
	}

}
