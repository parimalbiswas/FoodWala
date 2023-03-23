package com.foodwala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.ItemException;
import com.foodwala.model.Item;
import com.foodwala.repository.ItemRepo;

@Service
public class ItemServiceImpl implements ItemService
{
	@Autowired
	private ItemRepo iRepo;

	@Override
	public Item addItem(Item item) throws ItemException
	{
		return iRepo.save(item);
	}

	@Override
	public Item updateItem(Item item) throws ItemException
	{
		Item existItem = iRepo.findById(item.getItem_Id())
				.orElseThrow(() -> new ItemException("Item not found with this Id"));

		existItem.setCost(item.getCost());
		existItem.setItem_names(item.getItem_names());
		existItem.setQuantity(item.getQuantity());
		existItem.setRest_category(item.getRest_category());

		return iRepo.save(existItem);
	}

	@Override
	public Item deleteItem(Integer item_id) throws ItemException
	{
		Item item = iRepo.findById(item_id).orElseThrow(() -> new ItemException("Item not found with this Id"));

		iRepo.deleteById(item_id);

		return item;

	}

	@Override
	public Item viewItem(Integer item_id) throws ItemException
	{
		Item item = iRepo.findById(item_id).orElseThrow(() -> new ItemException("Item not found with this Id"));

		return item;
	}

	@Override
	public List<Item> viewAllItem() throws ItemException
	{
		List<Item> items = iRepo.findAll();

		if (items.isEmpty())
		{
			throw new ItemException("No Item found");
		}

		return items;
	}

}
