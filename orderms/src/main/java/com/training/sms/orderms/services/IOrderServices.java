package com.training.sms.orderms.services;

import com.training.sms.orderms.dto.CreateOrderRequest;
import com.training.sms.orderms.dto.OrderDetails;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public interface IOrderServices {

	OrderDetails create(CreateOrderRequest request);

	OrderDetails findByOrderId(@Size(min = 3) String orderId);

	List<OrderDetails> ordersByCustomer(@Min(1) Long customerId);

	List<OrderDetails> findOrdersBetween(LocalDate startDate, LocalDate endDate);

}