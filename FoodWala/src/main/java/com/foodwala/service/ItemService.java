package com.foodwala.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodwala.exception.ItemException;
import com.foodwala.exception.LoginException;
import com.foodwala.model.Item;

@Service
public interface ItemService
{
	public Item addItem(Item item, String key) throws ItemException, LoginException;

	public Item updateItem(Item item, String key) throws ItemException, LoginException;

	public Item deleteItem(Integer item_id, String key) throws ItemException, LoginException;

	public Item viewItem(Integer item_id, String key) throws ItemException, LoginException;

	public List<Item> viewAllItem(String key) throws ItemException, LoginException;

	public Item increaseQuantityItem(Integer qnty, Integer item_id, String key) throws ItemException, LoginException;

}
