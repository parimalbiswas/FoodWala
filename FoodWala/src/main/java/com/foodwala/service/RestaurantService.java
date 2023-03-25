package com.foodwala.service;

import java.lang.module.ResolutionException;

import org.springframework.stereotype.Service;

import com.foodwala.exception.LoginException;
import com.foodwala.exception.RestaurantException;
import com.foodwala.model.Restaurant;

@Service
public interface RestaurantService
{

	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException;

	public Restaurant updateRestaurant(Restaurant restaurant, String key) throws RestaurantException, LoginException;

	public Restaurant deleteRestaurant(Integer rest_Id, String key) throws RestaurantException, LoginException;

	public Restaurant viewRestaurant(Integer rest_Id, String key) throws ResolutionException, LoginException;

}
