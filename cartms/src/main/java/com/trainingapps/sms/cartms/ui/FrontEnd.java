package com.trainingapps.sms.cartms.ui;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingapps.sms.cartms.dto.AddItemToCart;
import com.trainingapps.sms.cartms.dto.CartDetails;
import com.trainingapps.sms.cartms.dto.CreateCartRequest;
import com.trainingapps.sms.cartms.entities.Cart;
import com.trainingapps.sms.cartms.exception.CartNotFoundException;
import com.trainingapps.sms.cartms.exception.CustomerNotFoundException;
import com.trainingapps.sms.cartms.exception.InvalidCartIdException;
import com.trainingapps.sms.cartms.exception.InvalidCustomerIdException;
import com.trainingapps.sms.cartms.exception.InvalidUnitCountException;
import com.trainingapps.sms.cartms.services.CartService;

@Component
public class FrontEnd {

	@Autowired
	private CartService service;

	public void start() {
		try {

			CreateCartRequest cartRequest1 = new CreateCartRequest();
			cartRequest1.setCustomerId(11111L);
			CartDetails req1 = service.createCart(cartRequest1);
			display(req1);
		

			AddItemToCart requestData1 = new AddItemToCart();
			requestData1.setCustomerId(req1.getCustomerId());
			requestData1.setStockId(101l);
			requestData1.setUnits(10);
			service.addItemToCart(requestData1);
			

			Long customerId = req1.getCustomerId();
			CartDetails fetched = service.findCartDetailsByCustomerId(customerId);
			display(fetched);

		} catch (InvalidCartIdException e) {
			e.getMessage();
		} catch (InvalidCustomerIdException e) {
			e.getMessage();
		} catch (InvalidUnitCountException e) {
			e.getMessage();
		} catch (CartNotFoundException e) {
			e.getMessage();
		} catch (CustomerNotFoundException e) {
			e.getMessage();
		}

	}

	void display(Cart cart) {
		System.out.println("CartID : " + cart.getCartId() + ", " + "CustomerID : " + cart.getCustomerId() + ", "
				+ "stockID : " + cart.getItemsInCart());
	}

	public void display(CartDetails crt) {
		System.out.println("CartID : " + crt.getCartId() + ", " + "CustomerID : " + crt.getCustomerId() + ", ");
		Map<Long, Integer> items = crt.getItemsInCart();
		if (items != null) {
			for (Long id : items.keySet()) {
				int units = items.get(id);
				System.out.println(" StockId :" + id + " " + " units :" + units);
			}
		}
	}
}
