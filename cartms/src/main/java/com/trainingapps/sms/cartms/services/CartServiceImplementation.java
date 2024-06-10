package com.trainingapps.sms.cartms.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainingapps.sms.cartms.dto.AddItemToCart;
import com.trainingapps.sms.cartms.dto.CartDetails;
import com.trainingapps.sms.cartms.dto.CreateCartRequest;
import com.trainingapps.sms.cartms.entities.Cart;
import com.trainingapps.sms.cartms.repository.CartRepository;
import com.trainingapps.sms.cartms.util.CartUtil;

@Transactional
@Service
public class CartServiceImplementation implements CartService {

	@Autowired
	private CartRepository repository;

	@Autowired
	private CartUtil cartUtil;
	
	public CartDetails  newCartDetails(Long customerId){
        return new CartDetails();
    }

	@Override
	public CartDetails createCart(CreateCartRequest request) {
		Cart cart = new Cart();
		cart.setCustomerId(request.getCustomerId());
		cart = repository.save(cart);
		return cartUtil.toDetails(cart);		 
	}

	/*
	 * addItemToCart() method is add item/items to the cart
	 * 
	 **/

	@Override
	public void addItemToCart(AddItemToCart requestData) {
		Cart cart = repository.findCartByCustomerId(requestData.getCustomerId());
		Map<Long, Integer> items = cart.getItemsInCart();
		if (items == null) {
			items = new HashMap<>();
			cart.setItemsInCart(items);
		}
		boolean exists = items.containsKey(requestData.getStockId());
		if (exists) {
			int quantity = items.get(requestData.getStockId());
			int newQuantity = quantity + requestData.getUnits();
			items.put(requestData.getStockId(), newQuantity);
		} else {items.put(requestData.getStockId(), requestData.getUnits());}
		repository.save(cart);

	}
	
	/*
	 * findCartDetailsByCustomerId() method is find cart for given customerId
	 * 
	 *
	 **/

	@Override
	public CartDetails findCartDetailsByCustomerId(Long customerId) {
		Cart cart = findCartByCustomerId(customerId);
		return cartUtil.toDetails(cart);
		 
	}

	/*
	 * findCartByCustomerId() method is find cart for given customerId
	 * 
	 *
	 **/
	@Override
	public Cart findCartByCustomerId(Long customerId) {
		return repository.findCartByCustomerId(customerId);
	}

}
