package com.foodwala.service;

import java.lang.module.ResolutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.LoginException;
import com.foodwala.exception.RestaurantException;
import com.foodwala.model.Address;
import com.foodwala.model.CurrentUserSession;
import com.foodwala.model.Restaurant;
import com.foodwala.repository.AddressRepo;
import com.foodwala.repository.CurrentUserSessionRepo;
import com.foodwala.repository.RestaurantRepo;

@Service
public class RestaurantServiceImpl implements RestaurantService
{
	@Autowired
	private RestaurantRepo restRepo;

	@Autowired
	private AddressRepo addRepo;

	@Autowired
	private CurrentUserSessionRepo cSessionRepo;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException
	{
		return restRepo.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant, String key) throws RestaurantException, LoginException
	{
		CurrentUserSession existSession = cSessionRepo.findByUuid(key);

		if (existSession == null)
		{
			throw new LoginException("Admin Not Loged In");
		}

		if (existSession.getKonhai().equals("ADMIN"))
		{
			Restaurant existrestaurant = restRepo.findById(restaurant.getRest_Id())
					.orElseThrow(() -> new ResolutionException(
							"Resturent is not present with this Id ==> " + restaurant.getRest_Id()));

			existrestaurant.setContact_number(restaurant.getContact_number());
			existrestaurant.setManager_name(restaurant.getManager_name());
			existrestaurant.setRest_name(restaurant.getRest_name());

			Address existAdreess = addRepo.findById(existrestaurant.getRest_address().getId())
					.orElseThrow(() -> new ResolutionException("Address NOt FOund"));
			existAdreess.setArea(restaurant.getRest_address().getArea());
			existAdreess.setBuildingName(restaurant.getRest_address().getBuildingName());
			existAdreess.setCity(restaurant.getRest_address().getCity());
			existAdreess.setPincode(restaurant.getRest_address().getPincode());
			existAdreess.setState(restaurant.getRest_address().getState());
			existAdreess.setStreetNo(restaurant.getRest_address().getStreetNo());

			addRepo.save(existAdreess);
			existrestaurant.setRest_address(existAdreess);

			return restRepo.save(existrestaurant);
		}
		else
		{
			throw new LoginException("Only Admin are allowed to add Item. ==== You ARE NOTY ADMIN");
		}

	}

	@Override
	public Restaurant deleteRestaurant(Integer rest_Id, String key) throws RestaurantException, LoginException
	{
		CurrentUserSession existSession = cSessionRepo.findByUuid(key);

		if (existSession == null)
		{
			throw new LoginException("Admin Not Loged In");
		}

		if (existSession.getKonhai().equals("ADMIN"))
		{
			Restaurant existrestaurant = restRepo.findById(rest_Id)
					.orElseThrow(() -> new ResolutionException("Resturent is not present with this Id ==> " + rest_Id));

			restRepo.delete(existrestaurant);

			return existrestaurant;
		}
		else
		{
			throw new LoginException("Only Admin are allowed to add Item. ==== You ARE NOTY ADMIN");
		}

	}

	@Override
	public Restaurant viewRestaurant(Integer rest_Id, String key) throws ResolutionException, LoginException
	{

		CurrentUserSession existSession = cSessionRepo.findByUuid(key);

		if (existSession == null)
		{
			throw new LoginException("Admin Not Loged In");
		}

		if (existSession.getKonhai().equals("ADMIN"))
		{
			Restaurant existrestaurant = restRepo.findById(rest_Id)
					.orElseThrow(() -> new ResolutionException("Resturent is not present with this Id ==> " + rest_Id));

			return existrestaurant;
		}
		else
		{
			throw new LoginException("Only Admin are allowed to add Item. ==== You ARE NOTY ADMIN");
		}

	}

}
