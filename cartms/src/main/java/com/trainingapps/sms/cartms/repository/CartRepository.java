package com.trainingapps.sms.cartms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingapps.sms.cartms.entities.Cart;


public interface CartRepository extends JpaRepository<Cart,Long>{

	Cart findCartByCustomerId(Long customerId);
}
