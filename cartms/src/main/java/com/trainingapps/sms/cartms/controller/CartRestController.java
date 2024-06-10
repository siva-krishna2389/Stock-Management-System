package com.trainingapps.sms.cartms.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.sms.cartms.dto.AddItemToCart;
import com.trainingapps.sms.cartms.dto.CartDetails;
import com.trainingapps.sms.cartms.dto.CreateCartRequest;
import com.trainingapps.sms.cartms.entities.Cart;
import com.trainingapps.sms.cartms.services.CartService;
import com.trainingapps.sms.cartms.util.CartUtil;

@Validated
@RestController
public class CartRestController {

	@Autowired
	private CartUtil cartUtil;

	@Autowired
	private CartService service;

	/*
	 * create the Cart request for customerId
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/c/add")
	public CartDetails createCart(@RequestBody @Valid CreateCartRequest cartRequest) {
		return service.createCart(cartRequest);}

	/*
	 * create the adding items to the cart
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/c/items/add")
	public String addItemsToCart(@RequestBody @Valid AddItemToCart request) {
		service.addItemToCart(request);
		return "item Added";}

	/*
	 * getting cart details by customer Id
	 */
	@GetMapping("/c/byid/{id}")
	public CartDetails findCartDetailsByCustomerId(@Min(1) @PathVariable("id") Long id) {
		Cart cart = service.findCartByCustomerId(id);
		return cartUtil.toDetails(cart);}

}
