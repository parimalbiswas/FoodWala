package com.foodwala.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodwala.exception.ItemException;
import com.foodwala.model.Item;

@Service
public interface ItemService
{
	public Item addItem(Item item) throws ItemException;

	public Item updateItem(Item item) throws ItemException;

	public Item deleteItem(Integer item_id) throws ItemException;

	public Item viewItem(Integer item_id) throws ItemException;

	public List<Item> viewAllItem() throws ItemException;

}
