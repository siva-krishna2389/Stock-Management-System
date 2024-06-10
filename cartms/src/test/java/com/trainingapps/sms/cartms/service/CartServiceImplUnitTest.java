package com.trainingapps.sms.cartms.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trainingapps.sms.cartms.dto.CartDetails;
import com.trainingapps.sms.cartms.dto.CreateCartRequest;
import com.trainingapps.sms.cartms.entities.Cart;
import com.trainingapps.sms.cartms.repository.CartRepository;
import com.trainingapps.sms.cartms.services.CartServiceImplementation;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplUnitTest {

	@Mock
	CartRepository repository;

	@Spy
	@InjectMocks
	CartServiceImplementation service;


	/**
	 * scenario: Cart found for CustomerId
	 */
//	@Test
//	public void testFindCartByCustomerId_1() {
//
//		long id = 1;
//		Cart cart = mock(Cart.class);
//		Cart saved = mock(Cart.class);
//		doReturn(cart).when(service).newCart(id);
//		when(repository.save(cart)).thenReturn(saved);
//		Cart result = service.findCartByCustomerId(id);
//		assertSame(cart, result);
//		verify(repository).findById(id);
//		when(repository.save(cart)).thenReturn(saved);
//	}
}
