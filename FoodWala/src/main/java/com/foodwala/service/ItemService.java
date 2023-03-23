package com.foodwala.service;

import org.springframework.stereotype.Service;

import com.foodwala.exception.ItemException;
import com.foodwala.model.Item;
import com.foodwala.model.Restaurant;

@Service
public interface ItemService
{

	public Restaurant addItem(Item item) throws ItemException;

	public Restaurant updateItem(Item item) throws ItemException;

	public Restaurant deleteItem(Integer item_id) throws ItemException;

	public Restaurant viewItem(Integer item_id) throws ItemException;

	public Restaurant viewAllItem() throws ItemException;

}
