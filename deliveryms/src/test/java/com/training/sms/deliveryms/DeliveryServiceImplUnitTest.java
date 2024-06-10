package com.training.sms.deliveryms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trainingapps.sms.deliveryms.constants.DeliveryStatus;
import com.trainingapps.sms.deliveryms.dto.DeliveryDetails;
import com.trainingapps.sms.deliveryms.entities.Delivery;
import com.trainingapps.sms.deliveryms.exceptions.IdNotFoundException;
import com.trainingapps.sms.deliveryms.repository.IDeliveryRepository;
import com.trainingapps.sms.deliveryms.services.DeliveryServiceImpl;

/*
 * Test class for delivery service implementation
 */
@ExtendWith(MockitoExtension.class)
public class DeliveryServiceImplUnitTest {
	
	/*
	 * Create a mock object of the repository class
	 */
	@Mock
	IDeliveryRepository dao;
	
	/*
	 * Spy is the real time object
	 */
	@InjectMocks
	@Spy
	DeliveryServiceImpl service;
	
	
	/*
	 * Scenario: Delivery not found by id
	 */
	@Test
	public void findOrderByIdTest_1() {
	        String id = "10";
	        Executable executable=()->service.findByOrderId(id);
            assertThrows(IdNotFoundException.class,executable);
	    }
	}
























