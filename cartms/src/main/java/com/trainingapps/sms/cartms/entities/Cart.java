package com.trainingapps.sms.cartms.entities;


import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "cart")
@Entity
public class Cart {

	@Id
	@GeneratedValue
	private Long cartId;
	private Long customerId;
	private int units;

	// key is stock id , value is number of stocks
	@ElementCollection(fetch=FetchType.EAGER )
	private Map<Long, Integer> itemsInCart;

	public int getUnits() {return units;}

	public void setUnits(int units) {this.units = units;}

	public Long getCartId() {return cartId;}

	public Map<Long, Integer> getItemsInCart() {return itemsInCart;}

	public void setItemsInCart(Map<Long, Integer> itemsInCart) {this.itemsInCart = itemsInCart;}

	public void setCartId(Long cartId) {this.cartId = cartId;}

	public Long getCustomerId() {return customerId;}

	public void setCustomerId(Long customerId) {this.customerId = customerId;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cartId ^ (cartId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}

}
