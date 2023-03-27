package com.foodwala.controller;

import java.lang.module.ResolutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.LoginException;
import com.foodwala.exception.RestaurantException;
import com.foodwala.model.Restaurant;
import com.foodwala.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController
{
	@Autowired
	private RestaurantService rService;

	@PostMapping("/add")
	public ResponseEntity<Restaurant> addRestaurentHandler(@RequestBody Restaurant restaurant)
			throws RestaurantException
	{
		Restaurant addedRestaurant = rService.addRestaurant(restaurant);
		return new ResponseEntity<>(addedRestaurant, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<Restaurant> updateRestaurentHandler(@RequestBody Restaurant restaurant,
			@RequestParam("key") String key) throws RestaurantException, LoginException
	{
		Restaurant updateRestaurant = rService.updateRestaurant(restaurant, key);
		return new ResponseEntity<>(updateRestaurant, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Restaurant> deleteRestaurentHandler(@PathVariable("id") Integer rest_Id,
			@RequestParam("key") String key) throws RestaurantException, LoginException
	{
		Restaurant deleteRestaurant = rService.deleteRestaurant(rest_Id, key);
		return new ResponseEntity<>(deleteRestaurant, HttpStatus.OK);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Restaurant> viewRestaurentHandler(@PathVariable("id") Integer rest_Id,
			@RequestParam("key") String key) throws RestaurantException, ResolutionException, LoginException
	{
		Restaurant Restaurant = rService.viewRestaurant(rest_Id, key);
		return new ResponseEntity<>(Restaurant, HttpStatus.OK);
	}

}
