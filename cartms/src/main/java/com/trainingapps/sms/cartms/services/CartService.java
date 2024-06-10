package com.trainingapps.sms.cartms.services;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.sms.cartms.dto.AddItemToCart;
import com.trainingapps.sms.cartms.dto.CartDetails;
import com.trainingapps.sms.cartms.dto.CreateCartRequest;
import com.trainingapps.sms.cartms.entities.Cart;

@Validated
public interface CartService {

	CartDetails createCart(@Valid CreateCartRequest request);

	void addItemToCart(AddItemToCart requestData);

	Cart findCartByCustomerId(@Min(1) Long customerId);

	CartDetails findCartDetailsByCustomerId(@Min(1) Long customerId);

}
