package com.foodwala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.RestaurantException;
import com.foodwala.model.Restaurant;
import com.foodwala.service.RestaurantService;

@RestController
public class RestaurantController
{
	@Autowired
	private RestaurantService rService;

	public ResponseEntity<Restaurant> addRestaurentHandler(@RequestBody Restaurant restaurant)
			throws RestaurantException
	{

		rService.addRestaurant(restaurant);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

}
