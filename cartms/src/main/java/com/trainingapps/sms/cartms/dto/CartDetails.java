package com.trainingapps.sms.cartms.dto;

import java.util.Map;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CartDetails {

	@Min(1)
	@NotNull
	private Long cartId;
	private Long customerId;
	private Map<Long, Integer> itemsInCart;

	public Long getCartId() {return cartId;}

	public void setCartId(Long cartId) {this.cartId = cartId;}

	public Long getCustomerId() {return customerId;}

	public void setCustomerId(Long customerId) {this.customerId = customerId;}

	public Map<Long, Integer> getItemsInCart() {return itemsInCart;}

	public void setItemsInCart(Map<Long, Integer> itemsInCart) {this.itemsInCart = itemsInCart;}

}
