package com.foodwala.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.ItemException;
import com.foodwala.model.Cart;
import com.foodwala.model.Item;
import com.foodwala.repository.CartRepo;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepo ctRepo;

	@Override
	public Cart saveCart(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
