package com.trainingapps.sms.cartms.util;

import java.util.*;

import org.springframework.stereotype.Component;

import com.trainingapps.sms.cartms.dto.CartDetails;
import com.trainingapps.sms.cartms.entities.Cart;

@Component
public class CartUtil {

	public CartDetails toDetails(Cart cart) {
		CartDetails cartDetails = new CartDetails();
		cartDetails.setCartId(cart.getCartId());
		cartDetails.setCustomerId(cart.getCustomerId());
		cartDetails.setItemsInCart(cart.getItemsInCart());
		return cartDetails;
	}

	public List<CartDetails> toDetailsList(Collection<Cart> items, CartDetails cartdetails) {

		List<CartDetails> desired = new ArrayList<>();
		for (Cart cart : items) {
			CartDetails details = toDetails(cart);
			desired.add(details);
		}return desired;}
}