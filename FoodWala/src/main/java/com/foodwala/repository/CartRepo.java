package com.foodwala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodwala.model.Cart;

public interface CartRepo  extends JpaRepository<Cart, Integer>{
	
	

}
