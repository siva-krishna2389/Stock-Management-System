package com.training.sms.orderms;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.sms.orderms.dao.IOrderRepository;
import com.training.sms.orderms.dto.OrderDetails;
import com.training.sms.orderms.entities.CreatedOrder;
import com.training.sms.orderms.services.OrderServiceImpl;

public class OrderServiceImplUtnitTest
{
	
	@Mock
	private IOrderRepository dao;
	
	@Spy
	@InjectMocks
	private OrderServiceImpl impl;
	
	/*
	 * scenario: when report is find by id
	 */
	/*
	@Test
	public void findReportByIdTest_1() {
		String orderId = "10";
		CreatedOrder created = mock(CreatedOrder.class);
		Optional<CreatedOrder> optional = Optional.of(created);
		when(dao.findById(orderId)).thenReturn(optional);
		OrderDetails result = impl.findByOrderId(orderId);
		assertSame(created, result);
		verify(dao).findById(orderId);
	}
	
	@Test
	public void findordersByCustomerIdTest_1() {
		Long customerId = 10L;
		CreatedOrder created = mock(CreatedOrder.class);
		Optional<CreatedOrder> optional = Optional.of(created);
		when(dao.findById(customerId)).thenReturn(optional);
		CreatedOrder result = impl.findBycustomerId(customerId);
		assertSame(created, result);
		verify(dao).findById(customerId);
	}
	*/
}