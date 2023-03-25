package com.foodwala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.ItemException;
import com.foodwala.exception.LoginException;
import com.foodwala.model.CurrentUserSession;
import com.foodwala.model.Item;
import com.foodwala.repository.CurrentUserSessionRepo;
import com.foodwala.repository.ItemRepo;

@Service
public class ItemServiceImpl implements ItemService
{
	@Autowired
	private ItemRepo iRepo;

	@Autowired
	private CurrentUserSessionRepo cSessionRepo;

	@Override
	public Item addItem(Item item, String key) throws ItemException, LoginException
	{
		CurrentUserSession existSession = cSessionRepo.findByUuid(key);

		if (existSession == null)
		{
			throw new LoginException("Admin Not Loged In");
		}

		if (existSession.getKonhai().equals("ADMIN"))
		{
			return iRepo.save(item);
		}
		else
		{
			throw new ItemException("Only Admin are allowed to add Item. ==== You ARE NOTY ADMIN");
		}

	}

	@Override
	public Item updateItem(Item item, String key) throws ItemException, LoginException
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
	public Item deleteItem(Integer item_id, String key) throws ItemException, LoginException
	{
		Item item = iRepo.findById(item_id).orElseThrow(() -> new ItemException("Item not found with this Id"));

		iRepo.deleteById(item_id);

		return item;

	}

	@Override
	public Item viewItem(Integer item_id, String key) throws ItemException, LoginException
	{
		Item item = iRepo.findById(item_id).orElseThrow(() -> new ItemException("Item not found with this Id"));

		return item;
	}

	@Override
	public List<Item> viewAllItem(String key) throws ItemException, LoginException
	{
		List<Item> items = iRepo.findAll();

		if (items.isEmpty())
		{
			throw new ItemException("No Item found");
		}

		return items;
	}

	@Override
	public Item increaseQuantityItem(Integer qnty, Integer item_id, String key) throws ItemException, LoginException
	{
		Item existItem = iRepo.findById(item_id).orElseThrow(() -> new ItemException("Item not found with this Id"));

		existItem.setQuantity(qnty);

		return iRepo.save(existItem);
	}

}
