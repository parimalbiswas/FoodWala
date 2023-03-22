package com.foodwala.service;

import java.lang.module.ResolutionException;

import org.springframework.stereotype.Service;

import com.foodwala.exception.RestaurantException;
import com.foodwala.model.Restaurant;

@Service
public interface RestaurantService
{

	public Restaurant addRestaurant(Restaurant restaurant);

	public Restaurant updateRestaurant(Restaurant restaurant);

	public Restaurant deleteRestaurant(Restaurant restaurant);

	public Restaurant viewRestaurant(Integer rest_Id) throws ResolutionException;

	public Restaurant viewAllRestaurant() throws RestaurantException;

}
