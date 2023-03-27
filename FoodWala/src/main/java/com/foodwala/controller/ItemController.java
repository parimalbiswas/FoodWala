package com.foodwala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.ItemException;
import com.foodwala.exception.LoginException;
import com.foodwala.model.Item;
import com.foodwala.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController
{
	@Autowired
	private ItemService iService;

	@PostMapping("/add")
	public ResponseEntity<Item> addItemHandler(@RequestBody Item item, @RequestParam("key") String key)
			throws ItemException, LoginException
	{
		Item addedItem = iService.addItem(item, key);
		return new ResponseEntity<>(addedItem, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<Item> updateItemHandler(@RequestBody Item item, @RequestParam("key") String key)
			throws ItemException, LoginException
	{
		Item updateItem = iService.updateItem(item, key);
		return new ResponseEntity<>(updateItem, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Item> deleteItemHandler(@PathVariable("id") Integer item_Id, @RequestParam("key") String key)
			throws ItemException, LoginException
	{
		Item delItem = iService.deleteItem(item_Id, key);
		return new ResponseEntity<>(delItem, HttpStatus.OK);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Item> viewItemHandler(@PathVariable("id") Integer item_Id, @RequestParam("key") String key)
			throws ItemException, LoginException
	{
		Item item = iService.viewItem(item_Id, key);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@GetMapping("/view/all")
	public ResponseEntity<List<Item>> viewAllItemHandler(@RequestParam("key") String key)
			throws ItemException, LoginException
	{
		List<Item> items = iService.viewAllItem(key);
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@PatchMapping("/update/quantity/{item_id}/{qnty}")
	public ResponseEntity<Item> increaseQuantityHandler(@PathVariable("item_id") Integer item_Id,
			@PathVariable("qnty") Integer qmty, @RequestParam("key") String key) throws ItemException, LoginException
	{
		Item items = iService.increaseQuantityItem(qmty, item_Id, key);

		return new ResponseEntity<>(items, HttpStatus.OK);
	}
}
